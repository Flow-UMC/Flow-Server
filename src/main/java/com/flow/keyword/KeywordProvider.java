package com.flow.keyword;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.flow.config.BaseException;
import static com.flow.config.BaseResponseStatus.*;

@Service
public class KeywordProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KeywordDao keywordDao;

    public List<Keyword> getAllKeywords(int userId) throws BaseException {
        try{
            return keywordDao.getAllKeywords(userId);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

}