package com.flow.flow.src.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private int isExp;
    private String info;
    private int amount;
    private String time;
    private String memo;
}

