package com.flow.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Budget {

    @Id @GeneratedValue
    private Long budgetId;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int startDay;
}
