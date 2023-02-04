package com.flow.detail;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProvider {
    @Autowired
    DetailDao detailDao;

    public List<Detail> getDetails(Pagination pagination, int userId, String year, String month){
        return detailDao.getDetails(pagination, userId, year, month);
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
