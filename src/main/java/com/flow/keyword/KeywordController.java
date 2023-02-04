package com.flow.keyword;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.flow.config.BaseResponse;
import static com.flow.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/keywords")
public class KeywordController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private final KeywordProvider keywordProvider;
    @Autowired
    private final KeywordService keywordService;


    public KeywordController(KeywordProvider keywordProvider, KeywordService keywordService){
       this.keywordProvider=keywordProvider;
       this.keywordService=keywordService;
    }

    @ResponseBody
    @GetMapping("/{userId}")
    public BaseResponse<List<Keyword>> getAllKeywords(@PathVariable("userId") int userId){
        List<Keyword> getKeywords=keywordProvider.getAllKeywords(userId);
        return new BaseResponse<>(getKeywords);
    }

    @ResponseBody
    @PatchMapping("/{userId}/{keywordId}")
    public BaseResponse<Keyword> modifyKeyword(@PathVariable("userId") int userId, @PathVariable("keywordId") int keywordId, @RequestBody ModifyKeyword keyword){
        Integer IntegerCategoryId=keyword.getCategoryId();
        if(IntegerCategoryId!=null && keyword.getKeyword()!=null){
            Keyword modifiedKeyword=keywordService.modifyKeyword(userId, keywordId, keyword);
            return new BaseResponse<>(modifiedKeyword);
        }
        return new BaseResponse<>(CHECK_KEYWORD);
    }

    @ResponseBody
    @DeleteMapping("/{userId}/{keywordId}")
    public BaseResponse<String> deleteKeyword(@PathVariable("userId") int userId, @PathVariable("keywordId") int keywordId){
        keywordService.deleteKeyword(userId, keywordId);
        String result="keywordId="+keywordId+"를 삭제하였습니다.";
        return new BaseResponse<>(result);
    }

}