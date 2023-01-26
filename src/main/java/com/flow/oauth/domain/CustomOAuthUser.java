package com.flow.oauth.domain;

import com.flow.user.domain.User;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collections;
import java.util.Map;

@Getter
public class CustomOAuthUser extends DefaultOAuth2User {
    private User user;
    private boolean join;

    public CustomOAuthUser(Map<String, Object> attributes, String nameAttributeKey, User user, boolean join) {
        super(Collections.singleton(new SimpleGrantedAuthority("USER")), attributes, nameAttributeKey);
        this.user = user;
        this.join = join;
    }
}
