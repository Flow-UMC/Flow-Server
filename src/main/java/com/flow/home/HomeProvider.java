package com.flow.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.Category;
import com.flow.model.CategoryDetail;
import com.flow.model.Expenditure;
import com.flow.model.GetCategoryDetailRes;
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
            int consumption = homeDao.getConsumption(userId, month) - homeDao.getExpenditure(userId, month);
            int lastConsumption = homeDao.getLastConsumption(userId, month);
            int percent = (consumption*100/budget);
            List<Category> categorys = homeDao.getCategorys(userId, month);
            List<Expenditure> expenditures = homeDao.getExpenditures(userId, month);

            GetHomeRes getHomeRes = new GetHomeRes(budget, consumption, lastConsumption, percent, categorys, expenditures);
            return getHomeRes;

        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.HOME_FAIL_ERROR);
        }
    }

    //카테고리 상세 내역 조회
    public GetCategoryDetailRes getCategoryDetail(int userId, int month, int categoryId) throws BaseException{
        try{
            int lastMoney = homeDao.getCategoryLastMoney(userId, month, categoryId);
            int thisMoney = homeDao.getCategoryThisMoney(userId, month, categoryId);
            List<CategoryDetail> categoryDetails = homeDao.getCategoryDetails(userId, month, categoryId);

            GetCategoryDetailRes getCategoryDetailRes = new GetCategoryDetailRes(lastMoney, thisMoney, categoryDetails);
            return getCategoryDetailRes;
        } catch(Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}