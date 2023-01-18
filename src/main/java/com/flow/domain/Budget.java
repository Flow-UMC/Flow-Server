package com.flow.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Budget {

    @Id @GeneratedValue
    private Long budgetId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int price;

    private int startDay;

    @Builder
    public Budget(int price, int startDay) {
        this.price = price;
        this.startDay = startDay;
    }
}