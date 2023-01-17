package com.flow.flow.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    private Long userId;

    private String email;

    private String userName;

    private String socialId;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @OneToOne(mappedBy = "user")
    private Budget budget;

    @Builder
    public User(String email, String userName, String socialId, SocialType socialType) {
        this.email = email;
        this.userName = userName;
        this.socialId = socialId;
        this.socialType = socialType;
    }
}
