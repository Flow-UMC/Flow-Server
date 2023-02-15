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
                        rs.getString("memo"))
                        ,getDetail2Params
        );
    }

    public int postDetail(PostDetailReq detail){
        Integer integratedId = detail.getIntegratedId();
        String query="select max(detailId) from detail";
        Integer param=this.jdbcTemplate.queryForObject(query, int.class);
        if(param==null){
            param=1;
        }
        else{
            param++;
        }
        String createDetailQuery = "insert into detail VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] createDetailParams = new Object[]{param,detail.getUserId(),detail.getCategoryId(),integratedId,detail.getYear(),detail.getMonth(),
            detail.getDay(),detail.getTime(),detail.getPrice(),detail.getShop(),detail.getTypeId(),detail.getIsBudgetIncluded(),detail.getIsKeywordIncluded(),detail.getMemo()};
        this.jdbcTemplate.update(createDetailQuery, createDetailParams);
        return param;
    }

    public void joinDetail(GetJoinDetailRes detailIds){
        int detailParam1=detailIds.getIntegratedId();
        int detailParam2=detailIds.getUserId();
        int[] detailParam3=detailIds.getDetailId();

        String joinDetailQuery1 ="update detail set integratedId = ? where userId= ? and detailId = ?";
        String joinDetailQuery2 ="update detail set integratedId = ? where userId= ? and integratedId = ?";
        for(int id:detailParam3){
            Object[] joinDetailParams1=new Object[]{detailParam1,detailParam2,id};
            Object[] joinDetailParams2=new Object[]{detailParam1,detailParam2,id};
            this.jdbcTemplate.update(joinDetailQuery1, joinDetailParams1);
            this.jdbcTemplate.update(joinDetailQuery2, joinDetailParams2); 
        }
    }

    public void deleteDetail(GetDeleteDetailRes detailIds){
        int detailParam1=detailIds.getUserId();
        int[] detailParam2=detailIds.getDetailId();

        String deleteTransQuery1="delete from detail where userId =? and detailId = ?";
        String deleteTransQuery2="delete from detail where userId =? and integratedId = ?";
        for(int id:detailParam2){
            Object[] deleteDetailParams1=new Object[]{detailParam1,id};
            Object[] deleteDetailParams2=new Object[]{detailParam1,id};
            this.jdbcTemplate.update(deleteTransQuery1,deleteDetailParams1);
            this.jdbcTemplate.update(deleteTransQuery2,deleteDetailParams2);
        }
    }

    //상세 내역 조회
    public GetDetailRes getDetail(int userId, int detailId) {
        String getDetailQuery = "select * from detail where userId = ? and detailId = ?";
        int getDetailUserParams = userId;
        int getDetailParams = detailId;
        return this.jdbcTemplate.queryForObject(getDetailQuery,
            (rs, rowNum) -> new GetDetailRes(
                rs.getInt("categoryId"),
                rs.getInt("integratedId"),
                rs.getString("year"),
                rs.getString("month"),
                rs.getString("day"),
                rs.getString("time"),
                rs.getInt("price"),
                rs.getString("shop"),
                rs.getBoolean("isBudgetIncluded"),
                rs.getString("memo")),
                getDetailUserParams,getDetailParams);
    }

    //상세 내역 변경
    public int modifyDetail(int userId, int detailId, PatchDetailReq patchDetailReq) {
        String modifyDetailQuery = "update detail set categoryId = ?, isBudgetIncluded = ?, isKeywordIncluded = ?, memo = ? where userId = ? and detailId = ?";
        Object[] modifyDetailParams = new Object[]{patchDetailReq.getCategoryId(), patchDetailReq.getIsBudgetIncluded(), patchDetailReq.getIsKeywordIncluded(), patchDetailReq.getMemo(), userId, detailId};

        return this.jdbcTemplate.update(modifyDetailQuery, modifyDetailParams);
    }

}
