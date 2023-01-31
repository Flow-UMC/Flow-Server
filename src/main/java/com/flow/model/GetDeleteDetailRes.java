package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class GetDeleteDetailRes {
    private int userId;
    private int[] detailId;
}