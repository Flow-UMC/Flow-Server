package com.flow.setting;

import com.flow.model.Form;
import com.flow.model.PatchBudgetReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SettingDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    public int modifyBudget(int userId, PatchBudgetReq patchBudgetReq){
        String query = "update budget set price = ?, startDay = ? where userId = ?";
        Object[] params = new Object[]{patchBudgetReq.getBudget(), patchBudgetReq.getStartDate(), userId};

        return this.jdbcTemplate.update(query, params);
    }

    public List<Form> getForm(String bankName) {
        String query = "select formId, form from form where bankName = ?";
        String params = bankName;

        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new Form(
                        rs.getInt("formId"),
                        rs.getString("form")),
                params);
    }

    @Transactional
    public int resetData(int userId){
        String delDetailQuery = "delete from detail where userId = ?";
        jdbcTemplate.update(delDetailQuery, userId);

        String delCategoryQuery = "delete from category where userId = ? and isUserCreated = 1";
        return this.jdbcTemplate.update(delCategoryQuery, userId);
    }

    @Transactional
    public int deleteUser(int userId){
        String delDetailQuery = "delete from detail where userId = ?";
        jdbcTemplate.update(delDetailQuery, userId);

        String delKeywordQuery = "delete from keyword where userId = ?";
        jdbcTemplate.update(delKeywordQuery, userId);

        String delCategoryQuery = "delete from category where userId = ?";
        jdbcTemplate.update(delCategoryQuery, userId);

        String delBudgetQuery = "delete from budget where userId = ?";
        jdbcTemplate.update(delBudgetQuery, userId);

        String delUserQuery = "delete from user where userId = ?";
        return this.jdbcTemplate.update(delUserQuery, userId);
    }

}

