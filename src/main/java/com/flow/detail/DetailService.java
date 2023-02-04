package com.flow.detail;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.flow.config.BaseException;
import static com.flow.config.BaseResponseStatus.*;

@Service
public class DetailService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DetailDao detailDao;

    public void postDetail(int userId, Detail detail) throws BaseException{
        if(userId!=detail.getUserId()){
            throw new BaseException(CHECK_USER_ID);
        }
        try{
            detailDao.postDetail(detail);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

    public void joinDetail(GetJoinDetailRes detailIds) throws BaseException{
        try{
            detailDao.joinDetail(detailIds);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

    public void deleteDetail(GetDeleteDetailRes detailIds) throws BaseException{
        try{
            detailDao.deleteDetail(detailIds);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }
}
