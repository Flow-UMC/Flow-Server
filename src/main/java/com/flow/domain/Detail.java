package com.flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Detail {

    @Id @GeneratedValue
    private Long detailId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int day;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String shop;

    @Column(nullable = false)
    private boolean isExp;

    @Column(nullable = false)
    private boolean isIncluded;

    // 통합내역 id

    @Column(nullable = false)
    private boolean isChanged;

    @Column(nullable = false)
    private String memo;
}
