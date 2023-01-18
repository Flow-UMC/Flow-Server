package com.flow.flow.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<Detail> details = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Keyword keyword;

    @Builder
    public User(String email, String userName, String socialId, SocialType socialType) {
        this.email = email;
        this.userName = userName;
        this.socialId = socialId;
        this.socialType = socialType;
    }
}
