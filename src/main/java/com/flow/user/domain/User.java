package com.flow.user.domain;

import lombok.*;

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
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider provider;

    @OneToOne(mappedBy = "user")
    private Budget budget;

    @Builder
    public User(String email, String name, AuthProvider provider) {
        this.email = email;
        this.name = name;
        this.provider = provider;
    }
}
