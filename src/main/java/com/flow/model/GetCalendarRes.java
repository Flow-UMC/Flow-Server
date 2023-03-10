package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCalendarRes {
    private String date;
    private int isExp;
    private int amount;
}