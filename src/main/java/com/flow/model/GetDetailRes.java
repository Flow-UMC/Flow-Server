package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetDetailRes {
    private int categoryId;
    private int integratedId;
    private String year;
    private String month;
    private String day;
    private String time;
    private int price;
    private String shop;
    private Boolean isBudgetIncluded;
    private String memo;
}