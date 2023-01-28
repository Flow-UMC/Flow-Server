package com.flow.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flow.config.BaseException;
import com.flow.config.BaseResponseStatus;
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
    
}
