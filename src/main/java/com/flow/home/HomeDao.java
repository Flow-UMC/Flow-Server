package com.flow.home;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flow.model.Category;
import com.flow.model.CategoryDetail;
import com.flow.model.Expenditure;


@Repository
public class HomeDao {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //예산 시작일 조회
    public int getBudgetStartDay(int userId) {
        String getBudgetStartDayQuery = "select startDay from budget where userId = ?";

        Object[] getBudgetStartDayParams = new Object[]{userId};
        return this.jdbcTemplate.queryForObject(getBudgetStartDayQuery, int.class, getBudgetStartDayParams);
    }

    //홈 조회 - 예산
    public int getBudget(int userId, int month) {
        String getBudgetQuery = "select price from budget where userId = ?";

        Object[] getBudgetParams = new Object[]{userId};
        return this.jdbcTemplate.queryForObject(getBudgetQuery, int.class, getBudgetParams);
    }

     //홈 조회 - 이번 달 지출
     public int getConsumption(int userId, int month){
        int nextMonth;
        if(month == 12) {
            nextMonth = 1;
        } else {
            nextMonth = month + 1;
        }
        try {
            String getConsumptionQuery = "select sum(price) from (select * from detail where month = ? and day >= ? or month = ? and day < ?) tb where userId = ? and typeId = 1 and integratedId = -1 and isBudgetIncluded = 1";

            Object[] getConsumptionParams = new Object[]{month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId};
            return this.jdbcTemplate.queryForObject(getConsumptionQuery, int.class, getConsumptionParams); 
        } catch (Exception e) {
            return 0;
        }
        
    }

    //홈 조회 - 이번 달 통합 내역 지출
    public int getIntegratedConsumption(int userId, int month){
        int nextMonth;
        if(month == 12) {
            nextMonth = 1;
        } else {
            nextMonth = month + 1;
        }
        try {
            String getConsumptionQuery = "select sum(price) from (select sum(price) as price from (select integratedId, if (typeId = 2, price, -price) as price from (select * from detail where month = ? and day >= ? or month = ? and day < ?) tb where userId = ? and isBudgetIncluded = 1 and integratedId != -1) price_table group by integratedId) expend_table where price < 0";
        
            Object[] getConsumptionParams = new Object[]{month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId};
            return this.jdbcTemplate.queryForObject(getConsumptionQuery, int.class, getConsumptionParams); 
        } catch (Exception e) {
            return 0;
        }
    }

    //홈 조회 - 지난 달 소비금액
    public int getLastConsumption(int userId, int month){
        int lastMonth;
        if (month == 1)
            lastMonth = 12;
        else
            lastMonth = month - 1 ;

        return getConsumption(userId, lastMonth) - getIntegratedConsumption(userId, lastMonth);
    }

    //홈 조회 - 카테고리 이름 조회
    public String getCategoryName(int userId, int categoryId) {
        String getCategoryNameQuery = "select name from category where userId = ? and categoryId= ?";
    
        Object[] getCategoryNameParams = new Object[]{userId, categoryId};
        return this.jdbcTemplate.queryForObject(getCategoryNameQuery, String.class, getCategoryNameParams);
    
    }

    //홈 조회 - 카테고리 별 소비 금액
    public List<Category> getCategorys(int userId, int month) {
        int nextMonth;
        if(month == 12) {
            nextMonth = 1;
        } else {
            nextMonth = month + 1;
        }

        String getCategorysQuery = "select categoryId, sum(price) as price from ( select categoryId, price from (select * from detail where month = ? and day >= ? or month = ? and day < ?) date_tb where userId = ? and typeId = 1 and integratedId = -1 and isBudgetIncluded = 1 union all select detail.categoryId, -b.price from detail right join (select * from (select integratedId, sum(price) as price from (select integratedId, if (typeId = 2, price, -price) as price from (select * from detail where month = ? and day >= ? or month = ? and day < ?) date_tb where userId = ? and isBudgetIncluded = 1 and integratedId != -1 ) tb group by integratedId) tb_next where price < 0 ) b on detail.detailId = b.integratedId) a group by categoryId order by categoryId";
        
        Object[] getCategorysParams = new Object[]{month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId, month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId};

        try {
            return this.jdbcTemplate.query(getCategorysQuery, 
            (rs, rowNum) -> new Category(
                rs.getInt("categoryId"),
                getCategoryName(userId, rs.getInt("categoryId")),
                rs.getInt("price"),
                ((rs.getInt("price")*100)/(getConsumption(userId, month)-getIntegratedConsumption(userId, month)))
        ),
            getCategorysParams);
        } catch (Exception e) {
            return this.jdbcTemplate.query(getCategorysQuery, 
            (rs, rowNum) -> new Category(
                rs.getInt("categoryId"),
                getCategoryName(userId, rs.getInt("categoryId")),
                rs.getInt("price"),
                (0)
        ),
            getCategorysParams);
        }

    }

     //홈 조회 - 월 별 지출 금액
     public List<Expenditure> getExpenditures(int userId, int month) {
        
        List<Expenditure> resultList = new ArrayList<>();

        if(month == 2){
            resultList.add(new Expenditure(1, getConsumption(userId, 1)-getIntegratedConsumption(userId, 1)));
            resultList.add(new Expenditure(2, getConsumption(userId, 2)-getIntegratedConsumption(userId, 2)));
        }
        else if (month < 8) {
            resultList.add(new Expenditure(1, getConsumption(userId, 1)-getIntegratedConsumption(userId, 1)));
            resultList.add(new Expenditure(2, getConsumption(userId, 2)-getIntegratedConsumption(userId, 2)));
            resultList.add(new Expenditure(3, getConsumption(userId, 3)-getIntegratedConsumption(userId, 3)));
            resultList.add(new Expenditure(4, getConsumption(userId, 4)-getIntegratedConsumption(userId, 4)));
            resultList.add(new Expenditure(5, getConsumption(userId, 5)-getIntegratedConsumption(userId, 5)));
            resultList.add(new Expenditure(6, getConsumption(userId, 6)-getIntegratedConsumption(userId, 6)));
            resultList.add(new Expenditure(7, getConsumption(userId, 7)-getIntegratedConsumption(userId, 7)));
        }
        else {
            resultList.add(new Expenditure(6, getConsumption(userId, 6)-getIntegratedConsumption(userId, 6)));
            resultList.add(new Expenditure(7, getConsumption(userId, 7)-getIntegratedConsumption(userId, 7)));
            resultList.add(new Expenditure(8, getConsumption(userId, 8)-getIntegratedConsumption(userId, 8)));
            resultList.add(new Expenditure(9, getConsumption(userId, 9)-getIntegratedConsumption(userId, 9)));
            resultList.add(new Expenditure(10, getConsumption(userId, 10)-getIntegratedConsumption(userId, 10)));
            resultList.add(new Expenditure(11, getConsumption(userId, 11)-getIntegratedConsumption(userId, 11)));
            resultList.add(new Expenditure(12, getConsumption(userId, 12)-getIntegratedConsumption(userId, 12)));
        }
        return resultList;
    }   

    //카테고리 상세 내역 조회 - 이번 달 카테고리 지출
    public int getCategoryThisMoney(int userId, int month, int categoryId){
        int nextMonth;
        if(month == 12) {
            nextMonth = 1;
        } else {
            nextMonth = month + 1;
        }
        try {
            String getConsumptionQuery = "select price from( select categoryId, sum(price) as price from ( select categoryId, price from (select * from detail where month = ? and day >= ? or month = ? and day < ?) date_tb where userId = ? and typeId = 1 and integratedId = -1 and isBudgetIncluded = 1 union all select detail.categoryId, -b.price from detail right join (select * from (select integratedId, sum(price) as price from (select integratedId, if (typeId = 2, price, -price) as price from (select * from detail where month = ? and day >= ? or month = ? and day < ?) date_tb where userId = ? and isBudgetIncluded = 1 and integratedId != -1 ) tb group by integratedId) tb_next where price < 0 ) b on detail.detailId = b.integratedId) a group by categoryId order by categoryId ) category_tb where categoryId = ?";
    
            Object[] getConsumptionParams = new Object[]{month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId, month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId, categoryId};
            return this.jdbcTemplate.queryForObject(getConsumptionQuery, int.class, getConsumptionParams); 
        } catch (Exception e) {
            return 0;
        }
    }
    
    //카테고리 상세 내역 조회  - 지난 달 카테고리 소비 금액
    public int getCategoryLastConsumption(int userId, int month, int categoryId){
        int lastMonth;
        if (month == 1)
            lastMonth = 12;
        else
            lastMonth = month - 1 ;
    
        return getCategoryThisMoney(userId, lastMonth, categoryId);
    }

    //카테고리 상세 내역 조회 - 상세 리스트
    public List<CategoryDetail> getCategoryDetails(int userId, int month, int categoryId) {
        int nextMonth;
        if(month == 12) {
            nextMonth = 1;
        } else {
            nextMonth = month + 1;
        }

        try {
            
        
        String getCategoryDetailListQuery = "select detailId, day, time, price, shop, memo from (select * from detail where month = ? and day >= ? or month = ? and day < ?) tb where userId = ? and categoryId = ?";

        Object[] getCategoryDetailListParams = new Object[]{month, getBudgetStartDay(userId), nextMonth, getBudgetStartDay(userId), userId, categoryId};

        return this.jdbcTemplate.query(getCategoryDetailListQuery, 
            (rs, rowNum) -> new CategoryDetail(
                rs.getInt("detailId"),
                rs.getString("day"),
                rs.getString("time"),
                rs.getInt("price"),
                rs.getString("shop"),
                rs.getString("memo")
            ),
            getCategoryDetailListParams);

        } catch (Exception e) {
            return null;
        }
    }
}