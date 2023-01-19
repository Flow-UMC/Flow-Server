package com.flow.service;

import com.flow.repository.FormRepository;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    private FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }
}
