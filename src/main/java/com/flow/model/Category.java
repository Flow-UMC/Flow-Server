package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private int categoryId;
    private String name;
    private int consumption;
    private int percent;
}
