package com.flow.calendar;

import com.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CalendarDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    public List<GetCalendarRes> getCalendar(String year, String month, int userId) {
        String getCalendarQuery = "select sum(price), typeId, day from detail" +
                " where userId = ? and year = ? and month = ? and isBudgetIncluded = 1" +
                " group by day, typeId";

        Object[] getCalendarParams = new Object[]{userId, year, month};

        return this.jdbcTemplate.query(getCalendarQuery,
                (rs, rowNum) -> new GetCalendarRes(
                        rs.getString("day"),
                        rs.getInt("typeId"),
                        rs.getInt("sum(price)")),
                getCalendarParams);
    }

    public List<GetTotalAmount> getTotalAmount(String year, String month, String date, int userId) {
        String getTotalQuery = "select sum(price), typeId from detail " +
                "where userId = ? and year = ? and month = ? and day = ? and isBudgetIncluded = 1 " +
                "group by typeId";
        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTotalQuery,
                (rs, rowNum) -> new GetTotalAmount(
                        rs.getInt("sum(price)"),
                        rs.getInt("typeId")),
                getTranParams);
    }

    public List<Detail> getDetail(String year, String month, String date, int userId) {
        String getTranQuery = "select * from detail " +
                "where userId = ? and year = ? and month = ? and day = ?";

        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTranQuery,
                (rs, rowNum) -> new Detail(
                        rs.getInt("detailId"),
                        rs.getInt("userId"),
                        rs.getInt("categoryId"),
                        rs.getInt("integratedId"),
                        rs.getString("year"),
                        rs.getString("month"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("price"),
                        rs.getString("shop"),
                        rs.getInt("typeId"),
                        rs.getBoolean("isBudgetIncluded"),
                        rs.getBoolean("isKeywordIncluded"),
                        rs.getString("memo")),
                getTranParams);
    }

}
