package com.flow.keyword;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeywordProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    KeywordDao keywordDao;

    public List<Keyword> getAllKeywords(int userId){
        return keywordDao.getAllKeywords(userId);
    }

}