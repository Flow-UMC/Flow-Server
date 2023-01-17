package com.flow.flow.detail.entity;

import com.flow.flow.user.entity.User;
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
    @JoinColumn(name = "userId")
    private User user;

    private int year;

    private int month;

    private int day;

    private int time;

    private int price;

    private String shop;

    // category id

    private int typeId;

    private boolean isIncluded;

    // 통합내역 id

    private boolean isChanged;

    private String memo;

}
