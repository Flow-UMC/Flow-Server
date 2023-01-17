package com.flow.flow.keyword.service;

import com.flow.flow.keyword.repository.KeywordRepository;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
    private KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }
}
