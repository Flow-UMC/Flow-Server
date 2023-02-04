package com.flow.detail;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DetailProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DetailDao detailDao;

    public List<Detail> getDetails(Pagination pagination, int userId, String year, String month){
        return detailDao.getDetails(pagination, userId, year, month);
    }
}
