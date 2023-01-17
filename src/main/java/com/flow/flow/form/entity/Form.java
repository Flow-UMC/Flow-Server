package com.flow.flow.form.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Form {

    @Id @GeneratedValue
    private Long formId;

    private String bankName;

    private boolean isExp;

    private String form;

    @Builder
    public Form(String bankName, boolean isExp, String form
    ) {
        this.bankName = bankName;
        this.isExp = isExp;
        this.form = form;
    }
}
