package com.flow.domain;

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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    @OneToOne(mappedBy = "user")
    private Budget budget;

    @OneToMany(mappedBy = "user")
    private List<Detail> details = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Keyword keyword;

    @OneToMany(mappedBy = "user")
    private List<Category> categories = new ArrayList<>();
}
