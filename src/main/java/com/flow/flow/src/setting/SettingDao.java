package com.flow.flow.src.setting;

import com.flow.flow.src.setting.model.Form;
import com.flow.flow.src.setting.model.PatchBudgetReq;
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
        String query = "delete from detail where userId = ?";
        int params = userId;

        return this.jdbcTemplate.update(query, params);
    }

}

