package com.flow.flow.detail.controller;

import com.flow.flow.detail.service.DetailService;
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
