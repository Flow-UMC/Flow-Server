package com.flow.flow.calendar;

import com.flow.flow.model.GetCalendarRes;
import com.flow.flow.model.GetTotalAmount;
import com.flow.flow.model.Transaction;
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
        String getCalendarQuery = "select sum(price), isExp, day from detail" +
                " where userId = ? and year = ? and month = ? and isBudgetIncluded = 1" +
                " group by day, isExp";

        Object[] getCalendarParams = new Object[]{userId, year, month};

        return this.jdbcTemplate.query(getCalendarQuery,
                (rs, rowNum) -> new GetCalendarRes(
                        rs.getString("day"),
                        rs.getInt("isExp"),
                        rs.getInt("sum(price)")),
                getCalendarParams);
    }

    public List<GetTotalAmount> getTotalAmount(String year, String month, String date, int userId) {
        String getTotalQuery = "select sum(price), isExp from detail " +
                "where userId = ? and year = ? and month = ? and day = ? and isBudgetIncluded = 1 " +
                "group by isExp";
        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTotalQuery,
                (rs, rowNum) -> new GetTotalAmount(
                        rs.getInt("sum(price)"),
                        rs.getInt("isExp")),
                getTranParams);
    }

    public List<Transaction> getTransaction(String year, String month, String date, int userId) {
        String getTranQuery = "select isExp, shop, price, time, memo from detail " +
                "where userId = ? and year = ? and month = ? and day = ?";

        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTranQuery,
                (rs, rowNum) -> new Transaction(
                        rs.getInt("isExp"),
                        rs.getString("shop"),
                        rs.getInt("price"),
                        rs.getString("time"),
                        rs.getString("memo")),
                getTranParams);
    }

}