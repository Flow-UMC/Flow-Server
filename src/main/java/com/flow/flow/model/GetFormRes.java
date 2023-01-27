package com.flow.flow.model;

import com.flow.flow.model.Form;
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
