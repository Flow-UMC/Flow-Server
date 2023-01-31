package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class GetJoinDetailRes {
    private int userId;
    private int integratedId;
    private int[] detailId;
}
