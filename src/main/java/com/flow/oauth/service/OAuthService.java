package com.flow.oauth.service;

import com.flow.oauth.domain.CustomOAuthUser;
import com.flow.oauth.domain.OAuthAttributes;
import com.flow.oauth.domain.UserProfile;
import com.flow.user.domain.User;
import com.flow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId();

        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        Map<String, Object> attributes = oAuth2User.getAttributes();

        UserProfile userProfile = OAuthAttributes.extract(registrationId, attributes);

        Optional<User> byOauthId = userRepository.findByOauthIdAndIsDeleted(userProfile.getOauthId(), "N");
        boolean join;
        User user;

        if (byOauthId.isEmpty()) {
            user = userProfile.toUser();
            join = false;
        } else {
            user = byOauthId.get();
            user.update(userProfile.getName(), userProfile.getEmail());
            join = true;
        }

        return new CustomOAuthUser(attributes, userNameAttributeName, user, join);
    }

    private User saveOrUpdate(UserProfile userProfile) {
        User user = (User) userRepository.findByOauthId(userProfile.getOauthId())
                .map(m -> m.update(userProfile.getName(), userProfile.getEmail()))
                .orElse(userProfile.toUser());
        return userRepository.save(user);
    }
}
