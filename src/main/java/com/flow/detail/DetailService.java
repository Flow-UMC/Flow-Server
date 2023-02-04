package com.flow.detail;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DetailDao detailDao;

    public void postDetail(Detail detail){
        detailDao.postDetail(detail);
    }

    public void joinDetail(GetJoinDetailRes detailIds){
        detailDao.joinDetail(detailIds);
    }

    public void deleteDetail(GetDeleteDetailRes detailIds){
        detailDao.deleteDetail(detailIds);
    }

        //상세 내역 수정(Patch)
        public void modifyDetail(int userId, int detailId, PatchDetailReq patchDetailReq) throws BaseException {
            try {
                int result = detailDao.modifyDetail(userId, detailId, patchDetailReq);
                if (result == 0) {
                    throw new BaseException(BaseResponseStatus.MODIFY_FAIL_DETAIL);
                }
            } catch (Exception exception) {
                throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
            }
        }
}
