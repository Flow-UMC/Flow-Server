package com.flow.flow.setting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetFormRes {
    private String bankName;
    private List<Form> form;
}
