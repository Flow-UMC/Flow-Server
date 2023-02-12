package com.flow.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchDetailReq {
    private int categoryId;
    private Boolean isBudgetIncluded;
    private Boolean isKeywordIncluded;
    private String memo;
}

