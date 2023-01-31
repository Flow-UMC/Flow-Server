package com.flow.oauth.domain;

import com.flow.user.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserProfile {
    private String name;
    private String email;
    private String provider;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .build();
    }
}
