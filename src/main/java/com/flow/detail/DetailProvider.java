package com.flow.detail;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProvider {
    @Autowired
    DetailDao detailDao;

    public List<Detail> getDetails(int userId, String year, String month){
        return detailDao.getDetails(userId, year, month);
    }
}
