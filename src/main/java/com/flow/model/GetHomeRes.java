package com.flow.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetHomeRes {
    private int budget;
    private int consumption;
    private int lastConsumption;
    private int percent;
    private List<Category> categoryData;
    private List<Expenditure> expenditureData;
}