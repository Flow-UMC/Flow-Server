package com.flow.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCategoryDetailRes {
    private int lastMoney;
    private int thisMoney;
    private List<CategoryDetail> categoryDetailList;
}