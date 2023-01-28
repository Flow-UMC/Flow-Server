package com.flow.detail;

import com.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.sql.DataSource;

@Repository
public class DetailDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    public List<Detail> getDetails(Pagination pagination, int userId, String year, String month){

        String getDetailsQuery1="select * from detail where userId=? order by year desc, month desc, day desc, time desc limit ? offset ?";
        String getDetailsQuery2="select * from detail where userId=? and year=? and month=? order by day desc, time desc limit ? offset ?";
        if(year.equals("all")){
            Object[] getDetail1Params=new Object[]{userId, pagination.getLimit(), pagination.getOffSet()};
            return this.jdbcTemplate.query(getDetailsQuery1,
                (rs, rowNum) -> new Detail(
                        rs.getInt("detailId"),
                        rs.getInt("userId"),
                        rs.getString("year"),
                        rs.getString("month"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("price"),
                        rs.getString("shop"),
                        rs.getInt("categoryId"),
                        rs.getInt("typeId"),
                        rs.getBoolean("isBudgetIncluded"),
                        rs.getInt("integratedId"),
                        rs.getBoolean("isChanged"),
                        rs.getString("memo"))
                        ,getDetail1Params);
        }
        int yearParam=Integer.parseInt(year);
        int monthParam=Integer.parseInt(month);
        Object[] getDetail2Params=new Object[]{userId, yearParam, monthParam,pagination.getLimit(),pagination.getOffSet()};
        return this.jdbcTemplate.query(getDetailsQuery2,
                (rs, rowNum) -> new Detail(
                        rs.getInt("detailId"),
                        rs.getInt("userId"),
                        rs.getString("year"),
                        rs.getString("month"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("price"),
                        rs.getString("shop"),
                        rs.getInt("categoryId"),
                        rs.getInt("typeId"),
                        rs.getBoolean("isBudgetIncluded"),
                        rs.getInt("integratedId"),
                        rs.getBoolean("isChanged"),
                        rs.getString("memo"))
                        ,getDetail2Params
        );
    }

    public void postDetail(Detail detail){
        String createDetailQuery = "insert into detail VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] createDetailParams = new Object[]{detail.getDetailId(),detail.getUserId(),detail.getYear(),detail.getMonth(),
            detail.getDay(),detail.getTime(),detail.getPrice(),detail.getShop(),detail.getCategoryId(),
            detail.getTypeId(),detail.getIsBudgetIncluded(),detail.getIntegratedId(),detail.getIsChanged(),detail.getMemo()};
        this.jdbcTemplate.update(createDetailQuery, createDetailParams);
    }

    public void joinDetail(GetJoinDetailRes detailIds){
        int detailParam1=detailIds.getIntegratedId();
        int detailParam2=detailIds.getUserId();
        int[] detailParam3=detailIds.getDetailId();

        String joinDetailQuery ="update detail set integratedId = ? where userId= ? and detailId in (";
        for(int id:detailParam3){
            joinDetailQuery+=Integer.toString(id)+",";
        }
        joinDetailQuery=joinDetailQuery.substring(0,joinDetailQuery.length()-1)+")";
        Object[] joinDetailParams=new Object[]{detailParam1,detailParam2};
        this.jdbcTemplate.update(joinDetailQuery, joinDetailParams);
    }

    public void deleteDetail(GetDeleteDetailRes detailIds){
        int detailParam1=detailIds.getUserId();
        int[] detailParam2=detailIds.getDetailId();

        String deleteTransQuery="delete from detail where userId =? and detailId in (";
        for(int id:detailParam2){
            deleteTransQuery+=Integer.toString(id)+",";
        }
        deleteTransQuery=deleteTransQuery.substring(0,deleteTransQuery.length()-1)+")";
        this.jdbcTemplate.update(deleteTransQuery,detailParam1);

    }
}