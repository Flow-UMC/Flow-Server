package com.flow.service;

import com.flow.repository.KeywordRepository;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
    private KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }
}
