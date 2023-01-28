package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {
    private int keywordId;
    private String keyword;
    private int categoryId;
    private int userId;
}