package com.flow.service;

import com.flow.repository.DetailRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    private DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }
}
