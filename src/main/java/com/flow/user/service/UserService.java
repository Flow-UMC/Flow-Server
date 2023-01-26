package com.flow.user.service;

import com.flow.oauth.domain.CustomOAuthUser;
import com.flow.user.domain.User;
import com.flow.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByOauthIdAndIsDeleted(String oauthId) {
        Optional<User> user = userRepository.findByOauthIdAndIsDeleted(oauthId, "N");
        return user.orElse(new User());
    }

    public User join(Authentication authentication) {
        CustomOAuthUser oAuthUser = (CustomOAuthUser) authentication.getPrincipal();
        return userRepository.save(oAuthUser.getUser());
    }

    public User findProfile(String oauthId) {
        return userRepository.findProfile(oauthId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
