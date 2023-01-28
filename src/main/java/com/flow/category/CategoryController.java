package com.flow.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import com.flow.model.PostCategoryReq;


@RestController
@RequestMapping("/category")

public class CategoryController {
    
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final CategoryProvider categoryProvider;
    
    @Autowired
    private final CategoryService categoryService;
    
    public CategoryController(CategoryProvider categoryProvider, CategoryService categoryService) {
        this.categoryProvider = categoryProvider;
        this.categoryService = categoryService;
    }

    //카테고리 추가 API
    // [POST] /category/add/:userId
    @ResponseBody
    @PostMapping("/add/{userId}")
    public BaseResponse<String> createCategory(
        @PathVariable("userId") int userId,
        @RequestBody PostCategoryReq category
    ) {
        try {
            PostCategoryReq postCategoryReq = new PostCategoryReq(category.getName(), category.getTypeId());
            categoryService.createCategory(userId, postCategoryReq);

            String result = "카테고리가 추가 되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}