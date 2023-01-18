package com.flow.controller;

import com.flow.service.FormService;
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
