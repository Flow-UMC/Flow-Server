package com.flow.flow.src.calendar;

import com.flow.flow.src.calendar.model.*;
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

    public List<GetCalendarRes> getCalendar(int year, int month, int userId) {
        String getCalendarQuery = "select sum(tran_amount), is_exp, date_format(tran_time, '%d') from transaction" +
                " where user_id = ? and date_format(tran_time, '%Y') = ? and date_format(tran_time, '%m') = ?" +
                " group by date_format(tran_time, '%d'), is_exp";

        Object[] getCalendarParams = new Object[]{userId, year, month};

        return this.jdbcTemplate.query(getCalendarQuery,
                (rs, rowNum) -> new GetCalendarRes(
                        rs.getInt("date_format(tran_time, '%d')"),
                        rs.getInt("is_exp"),
                        rs.getInt("sum(tran_amount)")),
                getCalendarParams);
    }

    public List<GetTotalAmount> getTotalAmount(int year, int month, int date, int userId) {
        String getTotalQuery = "select sum(tran_amount), is_exp from transaction " +
                "where user_id = ? and date_format(tran_time, '%Y') = ? and date_format(tran_time, '%m') = ? and date_format(tran_time, '%d') = ? " +
                "group by is_exp";
        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTotalQuery,
                (rs, rowNum) -> new GetTotalAmount(
                        rs.getInt("sum(tran_amount)"),
                        rs.getInt("is_exp")),
                getTranParams);
    }

    public List<Transaction> getTransaction(int year, int month, int date, int userId) {
        String getTranQuery = "select is_exp, tran_info, tran_amount, tran_time, memo from transaction " +
                "where user_id = ? and date_format(tran_time, '%Y') = ? and date_format(tran_time, '%m') = ? and date_format(tran_time, '%d') = ?";

        Object[] getTranParams = new Object[]{userId, year, month, date};

        return this.jdbcTemplate.query(getTranQuery,
                (rs, rowNum) -> new Transaction(
                        rs.getInt("is_exp"),
                        rs.getString("tran_info"),
                        rs.getInt("tran_amount"),
                        rs.getTime("tran_time"),
                        rs.getString("memo")),
                getTranParams);
    }

}


