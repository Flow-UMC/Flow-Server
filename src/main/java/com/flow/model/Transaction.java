package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

/*
{userId:Int, categoryId:Int, year:String, month:String, day:String, time:String,
price:String, shop:String, typeId:Int, isBudgetIncluded:Boolean, isKeywordIncluded:Boolean,
memo:String, integratedId:Int, detailId:Int}
 */

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private int userId;
    private int categoryId;
    private String year;
    private String month;
    private String day;
    private String time;
    private String price;
    private String shop;
    private int typeId;
    private boolean isBudgetIncluded;
    private boolean isKeywordIncluded;
    private String memo;
    private int integratedId;
    private int detailId;
}

