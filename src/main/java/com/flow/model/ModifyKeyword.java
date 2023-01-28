package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyKeyword {
    private String keyword;
    private int categoryId;
}