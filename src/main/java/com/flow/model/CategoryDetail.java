package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDetail {
    private int detailId;
    private String day;
    private String time;
    private int price;
    private String shop;
    private String memo;
}