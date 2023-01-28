package com.flow.keyword;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordProvider {
    @Autowired
    KeywordDao keywordDao;

    public List<Keyword> getAllKeywords(int userId){
        return keywordDao.getAllKeywords(userId);
    }

}