package com.flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id @GeneratedValue
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 7)
    private String name;

    @Column(nullable = false)
    private boolean isExp;

    @Column(nullable = false)
    private boolean isCreated;

    @OneToOne(mappedBy = "category")
    private Detail detail;

    @OneToOne(mappedBy = "category")
    private Keyword keyword;
}
