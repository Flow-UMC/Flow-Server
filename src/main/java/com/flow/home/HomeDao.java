package com.flow.home;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flow.model.Category;
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

}