package com.flow.keyword;

import com.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.flow.config.BaseException;
import static com.flow.config.BaseResponseStatus.*;

@Service
public class KeywordService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KeywordDao keywordDao;

    public Keyword modifyKeyword(int userId, int keywordId, ModifyKeyword keyword) throws BaseException {
        try{
            return keywordDao.modifyKeyword(userId, keywordId, keyword);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

    public void deleteKeyword(int userId, int keywordId) throws BaseException {
        try{
            keywordDao.deleteKeyword(userId, keywordId);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

}