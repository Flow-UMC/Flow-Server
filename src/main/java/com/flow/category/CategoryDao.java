package com.flow.category;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flow.model.PostCategoryReq;

@Repository
public class CategoryDao {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //카테고리 추가
    public int createCategory(int userId, PostCategoryReq postCategoryReq) {
        String postCategoryQuery = "insert into category (categoryId, userId, name, typeId, isUserCreated) values ((select ifnull(max(categoryId)+1,1) from category c),?,?,?,1)";
        Object[] postCategoryParams = new Object[]{userId, postCategoryReq.getName(), postCategoryReq.getTypeId()};

        return this.jdbcTemplate.update(postCategoryQuery, postCategoryParams);
    }

}
