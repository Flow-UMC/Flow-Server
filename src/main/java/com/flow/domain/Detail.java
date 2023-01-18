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

    private int year;

    private int month;

    private int day;

    private int time;

    private int price;

    private String shop;

    private boolean isExp;

    private boolean isIncluded;

    // 통합내역 id

    private boolean isChanged;

    private String memo;

}
