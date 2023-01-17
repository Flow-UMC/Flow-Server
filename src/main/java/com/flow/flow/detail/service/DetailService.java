package com.flow.flow.detail.service;

import com.flow.flow.detail.repository.DetailRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    private DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }
}
