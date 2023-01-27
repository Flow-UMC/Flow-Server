package com.flow.flow.model;

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
    private String time;
    private String memo;
}

