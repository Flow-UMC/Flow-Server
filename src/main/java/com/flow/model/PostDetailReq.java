package com.flow.model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDetailReq {
    private int userId;
    private int categoryId;
    private int integratedId;
    private String year;
    private String month;
    private String day;
    private String time;
    private int price;
    private String shop;
    private int typeId;
    private Boolean isBudgetIncluded;
    private Boolean isKeywordIncluded;
    private String memo;
}
