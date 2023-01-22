package com.flow.flow.src.setting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Access;

@Getter
@Setter
@AllArgsConstructor
public class Form {
    private int formId;
    private  String form;
}