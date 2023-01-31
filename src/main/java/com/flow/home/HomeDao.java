package com.flow.home;

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

    //홈 조회 - 예산
    public int getBudget(int userId, int month) {
        String getBudgetQuery = "select price from budget where userId = ?";

        Object[] getBudgetParams = new Object[]{userId};
        return this.jdbcTemplate.queryForObject(getBudgetQuery, int.class, getBudgetParams);
    }

    //홈 조회 - 이번 달 소비 금액
    public int getConsumption(int userId, int month){
        String getConsumptionQuery = "select sum(price) from detail where userId = ? and month = ?";

        Object[] getConsumptionParams = new Object[]{userId, month};
        return this.jdbcTemplate.queryForObject(getConsumptionQuery, int.class, getConsumptionParams); 
    }

    //홈 조회 - 지난 달 소비 금액
    public int getLastConsumption(int userId, int month){
        String getLastConsumptionQuery = "select sum(price) from detail where userId = ? and month = ?";

        int lastMonth;
        if(month == 1) {
            lastMonth = 12;
        } else {
            lastMonth =- 1;
        }

        Object[] getLastConsumptionParams = new Object[]{userId, lastMonth};
        return this.jdbcTemplate.queryForObject(getLastConsumptionQuery, int.class, getLastConsumptionParams); 
    }

    //홈 조회 - 카테고리 이름 조회
    public String getCategoryName(int userId, int categoryId) {
        String getCategoryNameQuery = "select name from category where userId = ? and categoryId= ?";
    
        Object[] getCategoryNameParams = new Object[]{userId, categoryId};
        return this.jdbcTemplate.queryForObject(getCategoryNameQuery, String.class, getCategoryNameParams);
    
    }

    //홈 조회 - 카테고리 별 소비 금액
    public List<Category> getCategorys(int userId, int month) {
        String getCategorysQuery = "select categoryId, sum(price) from detail where userId = ? and month = ? group by categoryId";
        
        Object[] getCategorysParams = new Object[]{userId, month};

        return this.jdbcTemplate.query(getCategorysQuery, 
            (rs, rowNum) -> new Category(
                rs.getInt("categoryId"),
                getCategoryName(userId, rs.getInt("categoryId")),
                rs.getInt("sum(price)"),
                (rs.getInt("sum(price)")/getBudget(userId, month))*100
        ),
            getCategorysParams);
    }

    //홈 조회 - 월 별 지출 금액
    public List<Expenditure> getExpenditures(int userId) {
        String getExpendituresQuery = "select month, sum(price) from detail where userId = ? group by month";

        Object[] getExpenditureParams = new Object[]{userId};

        return this.jdbcTemplate.query(getExpendituresQuery, 
            (rs, rowNum) -> new Expenditure(
                rs.getInt("month"),
                rs.getInt("sum(price)")
            ),
            getExpenditureParams);
    }   

    //카테고리 상세 내역 조회 - 이번 달 카테고리 지출
    public int getCategoryThisMoney(int userId, int month, int categoryId) {
        String getCategoryThisMoneyQuery = "select sum(price) from detail where userId = ? and month = ? and categoryId = ?";

        Object[] getCategoryThisMoneyParams = new Object[]{userId, month, categoryId};

        return this.jdbcTemplate.queryForObject(getCategoryThisMoneyQuery, int.class, getCategoryThisMoneyParams);
    }

    //카테고리 상세 내역 조회 - 지난 달 카테고리 지출
    public int getCategoryLastMoney(int userId, int month, int categoryId) {
        String getCategoryLastMoneyQuery = "select sum(price) from detail where userId = ? and month = ? and categoryId = ?";
        
        int lastMonth;
        if(month == 1) {
            lastMonth = 12;
        } else {
            lastMonth =- 1;
        }

        Object[] getCategoryLastMoneyParams = new Object[]{userId, lastMonth, categoryId};

        return this.jdbcTemplate.queryForObject(getCategoryLastMoneyQuery, int.class, getCategoryLastMoneyParams);
    }

    //카테고리 상세 내역 조회 - 상세 리스트
    public List<CategoryDetail> getCategoryDetails(int userId, int month, int categoryId) {
        String getCategoryDetailListQuery = "select day, time, price, shop, memo from detail where userId = ? and month = ? and categoryId = ?";

        Object[] getCategoryDetailListParams = new Object[]{userId, month, categoryId};

        return this.jdbcTemplate.query(getCategoryDetailListQuery, 
            (rs, rowNum) -> new CategoryDetail(
                rs.getString("day"),
                rs.getString("time"),
                rs.getInt("price"),
                rs.getString("shop"),
                rs.getString("memo")
            ),
            getCategoryDetailListParams);
    }
}