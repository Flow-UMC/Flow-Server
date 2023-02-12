package com.flow.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
import com.flow.model.PatchCategoryReq;
import com.flow.model.PostCategoryReq;

@Service
public class CategoryService {
    //final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CategoryDao categoryDao;
    
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    //카테고리 추가(Post)
    public void createCategory(int userId, PostCategoryReq postCategoryReq) throws BaseException {
        try {
            int result = categoryDao.createCategory(userId, postCategoryReq);
            if (result == 0) {
                throw new BaseException(BaseResponseStatus.CREATE_FAIL_CATEGORY);
            }
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
    
    //카테고리 수정(Patch)
    public void modifyCategory(int userId, int categoryId, PatchCategoryReq patchCategoryReq) throws BaseException {
        try {
            int result = categoryDao.modifyCategory(userId, categoryId, patchCategoryReq);
            if (result == 0) {
                throw new BaseException(BaseResponseStatus.MODIFY_FAIL_CATEGORY);
            }
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
    
    //카테고리 삭제(Delete)
    public void deleteCategory(int userId, int categoryId) throws BaseException {
        try {
            int modifyToEtcResult = categoryDao.modifyCategoryToEtc(userId, categoryId);
            int modifyToIncomeResult = categoryDao.modifyCategoryToIncome(userId, categoryId);
            int deleteKeywordResult = categoryDao.deleteCategoryKeyword(userId, categoryId);
            int result = categoryDao.deleteCategory(userId, categoryId);
            if (modifyToEtcResult == 0  && modifyToIncomeResult == 0 && deleteKeywordResult == 0 && result == 0 ) {
                throw new BaseException(BaseResponseStatus.MODIFY_FAIL_DETAIL);
            }
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
    
}
