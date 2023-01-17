package com.flow.flow.form.controller;

import com.flow.flow.form.service.FormService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/form")
public class FormController {
    private FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }
}
