package com.flow.keyword;

import com.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
    @Autowired
    KeywordDao keywordDao;

    public Keyword modifyKeyword(int userId, int keywordId, ModifyKeyword keyword){
        return keywordDao.modifyKeyword(userId, keywordId, keyword);
    }

    public void deleteKeyword(int userId, int keywordId){
        keywordDao.deleteKeyword(userId, keywordId);
    }

}