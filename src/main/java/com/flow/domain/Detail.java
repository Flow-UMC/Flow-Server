package com.flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "integrated_id")
    private Detail detail;

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

    @Column(nullable = false)
    private boolean isChanged;

    @Column(nullable = false)
    private String memo;

    @OneToMany(mappedBy = "detail")
    private List<Detail> integrated = new ArrayList<>();
}
