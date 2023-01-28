package com.flow.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.Category;
import com.flow.model.Expenditure;
import com.flow.model.GetHomeRes;

@Service
public class HomeProvider {

    private final HomeDao homeDao;

    @Autowired
    public HomeProvider(HomeDao homeDao) {
        this.homeDao = homeDao;
    }

    //홈 화면 조회
    public GetHomeRes getHome(int userId, int month) throws BaseException{
        try {
            int budget = homeDao.getBudget(userId, month);
            int consumption = homeDao.getConsumption(userId, month);
            int lastConsumption = homeDao.getLastConsumption(userId, month);
            int percent = (consumption/budget*100);
            List<Category> categorys = homeDao.getCategorys(userId, month);
            List<Expenditure> expenditures = homeDao.getExpenditures(userId);

            GetHomeRes getHomeRes = new GetHomeRes(budget, consumption, lastConsumption, percent, categorys, expenditures);
            return getHomeRes;

        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}