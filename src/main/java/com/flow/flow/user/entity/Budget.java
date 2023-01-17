package com.flow.flow.user.entity;

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
    @JoinColumn(name = "userId")
    private User user;

    private int price;

    private int startDay;

    @Builder
    public Budget(int price, int startDay) {
        this.price = price;
        this.startDay = startDay;
    }
}
