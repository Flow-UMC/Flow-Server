package com.flow.controller;

import com.flow.service.DetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class DetailController {
    private DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }
}
