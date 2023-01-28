package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private int page;
    private int limit = 30;

    public int getOffSet() {
        return (page - 1) * limit;
    }
}