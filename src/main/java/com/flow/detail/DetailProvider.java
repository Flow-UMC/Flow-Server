package com.flow.detail;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.flow.config.BaseException;
import static com.flow.config.BaseResponseStatus.*;

@Service
public class DetailProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DetailDao detailDao;

    public List<Detail> getDetails(Pagination pagination, int userId, String year, String month) throws BaseException{
        try{
            return detailDao.getDetails(pagination, userId, year, month);
        } catch(Exception exception){
            throw new BaseException(EXCEPTION_ERROR);
        }
    }

     //상세 내역 조회
     public GetDetailRes getDetail(int userId, int detailId) throws BaseException {
        try {
            GetDetailRes getDetailRes = detailDao.getDetail(userId, detailId);
            return getDetailRes;
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
