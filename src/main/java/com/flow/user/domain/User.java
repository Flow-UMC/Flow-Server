package com.flow.user.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String oauthId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String provider;

    private String isDeleted;

    @CreatedDate
    private String createdAt;

    @OneToOne(mappedBy = "user")
    private Budget budget;

    @Builder
    public User(String oauthId, String name, String email, String provider) {
        Assert.hasText(oauthId, "oauthId is empty");
        Assert.hasText(name, "name is empty");
        Assert.hasText(email, "email is empty");
        Assert.hasText(provider, "provider is empty");

        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.provider = provider;
    }

    public Object update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}
