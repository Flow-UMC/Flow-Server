package com.flow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetTranByDateRes {
    private List<GetTotalAmount> totalAmount;
    private List<Detail> detail;
}
