package com.flow.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.GetCategoryRes;

@Service
public class CategoryProvider {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryProvider(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    //카테고리 목록 조회
    public List<GetCategoryRes> getCategorys(int userId) throws BaseException {
        try {
            List<GetCategoryRes> getCategoryRes = categoryDao.getCategorys(userId);
            return getCategoryRes;
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}
