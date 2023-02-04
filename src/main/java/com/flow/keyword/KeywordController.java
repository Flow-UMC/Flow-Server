package com.flow.keyword;

import com.flow.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.flow.config.BaseException;
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
        try{
            List<Keyword> getKeywords=keywordProvider.getAllKeywords(userId);
            return new BaseResponse<>(getKeywords);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @PatchMapping("/{userId}/{keywordId}")
    public BaseResponse<Keyword> modifyKeyword(@PathVariable("userId") int userId, @PathVariable("keywordId") int keywordId, @RequestBody ModifyKeyword keyword){
        Integer IntegerCategoryId=keyword.getCategoryId();
        if(IntegerCategoryId==null || keyword.getKeyword()==null){
            return new BaseResponse<>(CHECK_KEYWORD);
        }
        try{
            Keyword modifiedKeyword=keywordService.modifyKeyword(userId, keywordId, keyword);
            return new BaseResponse<>(modifiedKeyword);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @DeleteMapping("/{userId}/{keywordId}")
    public BaseResponse<String> deleteKeyword(@PathVariable("userId") int userId, @PathVariable("keywordId") int keywordId){
        try{
            keywordService.deleteKeyword(userId, keywordId);
            String result="keywordId="+keywordId+"를 삭제하였습니다.";
            return new BaseResponse<>(result);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}