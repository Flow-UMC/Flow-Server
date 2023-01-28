package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCategoryRes {
    private int categoryId;
    private String name;
    private int typeId;
    private int isUserCreated;
}
