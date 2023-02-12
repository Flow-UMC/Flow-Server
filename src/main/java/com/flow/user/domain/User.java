package com.flow.user.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@DynamicInsert
@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isFingerprintOn;

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
