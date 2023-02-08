package com.flow.oauth.dto;

import com.flow.user.domain.User;
import lombok.Getter;

@Getter
public class SessionUser {

    private String name;
    private String email;
    private String provider;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.provider = user.getProvider();
    }
}
