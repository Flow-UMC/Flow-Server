package com.flow.detail;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
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
}
