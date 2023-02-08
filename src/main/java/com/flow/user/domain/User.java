package com.flow.user.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String provider;

    @OneToOne(mappedBy = "user")
    private Budget budget;

    @Builder
    public User(String name, String email, String provider) {
        this.name = name;
        this.email = email;
        this.provider = provider;
    }

    public Object update(String name) {
        this.name = name;
        return this;
    }
}
