package com.flow.flow.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCalendarRes {
    private int date;
    private int isExp;
    private int amount;
}