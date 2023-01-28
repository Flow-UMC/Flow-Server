package com.flow.model;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class GetDeleteDetailReq {
    private int[] detailId;
}
