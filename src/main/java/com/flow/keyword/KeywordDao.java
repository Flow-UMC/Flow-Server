package com.flow.keyword;

import com.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class KeywordDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Keyword> getAllKeywords(int userId) {
        String getPostsQuery = "select * from keyword where userId = ?";
        int getPostParam=userId;
        return this.jdbcTemplate.query(getPostsQuery,
                (rs, rowNum) -> new Keyword(
                        rs.getInt("keywordId"),
                        rs.getString("keyword"),
                        rs.getInt("categoryId"),
                        rs.getInt("userId"))
                        ,getPostParam
        );
    }

    public Keyword modifyKeyword(int userId, int keywordId, ModifyKeyword keyword){
        String modifyKeywordQuery="update keyword set categoryId =?, keyword=? where userId=? and keywordId=?";
        Object[] modifyKeywordParams = new Object[]{keyword.getCategoryId(), keyword.getKeyword(),userId,keywordId};
        this.jdbcTemplate.update(modifyKeywordQuery,modifyKeywordParams);
        String lastUpdatedKeywordIdQuery="select * from keyword where keywordId=?";
        int lastUpdatedKeywordParam=keywordId;
        return this.jdbcTemplate.queryForObject(lastUpdatedKeywordIdQuery,
                (rs, rowNum) -> new Keyword(
                        rs.getInt("keywordId"),
                        rs.getString("keyword"),
                        rs.getInt("categoryId"),
                        rs.getInt("userId")),
                        lastUpdatedKeywordParam);
    }

    public void deleteKeyword(int userId, int keywordId){
        String deleteKeywordQuery="delete from keyword where userId =? and keywordId =?";
        Object[] deleteKeywordParams = new Object[]{userId, keywordId};
        this.jdbcTemplate.update(deleteKeywordQuery,deleteKeywordParams);
    }

}