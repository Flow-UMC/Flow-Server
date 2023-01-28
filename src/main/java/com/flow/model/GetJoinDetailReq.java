package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class GetJoinDetailReq {
    private int integratedId;
    private int[] detailId;
}
