package com.flow.flow.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private int isExp;
    private String info;
    private int amount;
    private Time time;
    private String memo;
}

