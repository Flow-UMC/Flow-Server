package com.flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Form {

    @Id @GeneratedValue
    private Long formId;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private boolean isExp;

    @Column(nullable = false)
    private String form;
}
