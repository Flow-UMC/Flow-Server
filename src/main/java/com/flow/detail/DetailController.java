package com.flow.detail;

import com.flow.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private final DetailProvider detailProvider;
    @Autowired
    private final DetailService detailService;

    public DetailController(DetailProvider detailProvider, DetailService detailService){
       this.detailProvider=detailProvider;
       this.detailService=detailService; 
    }

    @ResponseBody
    @GetMapping("/{userId}")
    public BaseResponse<List<Detail>> getDetails(@PathVariable("userId") int userId, @RequestParam String year, @RequestParam String month, @RequestParam int page){
        //validation 추가
        try{
            Pagination pagination = new Pagination();
            pagination.setPage(page);
            List<Detail> details=detailProvider.getDetails(pagination, userId, year, month);
            return new BaseResponse<>(details);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @PostMapping("/{userId}")
    public BaseResponse<PostDetailRes> postDetail(@PathVariable("userId") int userId, @RequestBody PostDetailReq detail){
        try{
            PostDetailRes postDetailRes=detailService.postDetail(userId, detail);
            return new BaseResponse<>(postDetailRes);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @PatchMapping("/{userId}/join")
    public BaseResponse<String> joinDetail(@PathVariable("userId") int userId, @RequestBody GetJoinDetailReq detailIds){
        try{
            GetJoinDetailRes getJoinDetailRes = new GetJoinDetailRes(userId, detailIds.getIntegratedId(), detailIds.getDetailId());
            detailService.joinDetail(getJoinDetailRes);
            String result="detailId가 ";
            for(int id:detailIds.getDetailId()){
                result+=Integer.toString(id)+",";
            }
            result=result.substring(0,result.length()-1);
            result+="인 내역들의 대표id를 "+Integer.toString(detailIds.getIntegratedId())+"로 업데이트하였습니다.";
            return new BaseResponse<>(result);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @DeleteMapping("/{userId}")
    public BaseResponse<String> deleteDetail(@PathVariable("userId") int userId, @RequestBody GetDeleteDetailReq detailIds){
        try{
            GetDeleteDetailRes getDeleteDetailRes = new GetDeleteDetailRes(userId, detailIds.getDetailId());
            detailService.deleteDetail(getDeleteDetailRes);
            String result="detailId가 ";
            for(int id:detailIds.getDetailId()){
                result+=Integer.toString(id)+",";
            }
            result=result.substring(0,result.length()-1);
            result+="인 내역을 삭제하였습니다.";
            return new BaseResponse<>(result);
        } catch(BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    //상세 내역 1개 조회 API
    // [GET] /details/:userId/:detailId
    @ResponseBody
    @GetMapping("/{userId}/{detailId}")
    public BaseResponse<GetDetailRes> getDetail(@PathVariable("userId") int userId,
    @PathVariable("detailId") int detailId) {
        try {
            GetDetailRes getDetailRes = detailProvider.getDetail(userId, detailId);
            return new BaseResponse<>(getDetailRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //상세 내역 수정 API
    // [PATCH] /detail/:userId/:detailId
    @ResponseBody
    @PatchMapping("/{userId}/{detailId}")
    public BaseResponse<String> modifyDetail(
        @PathVariable("userId") int userId,
        @PathVariable("detailId") int detailId,
        @RequestBody PatchDetailReq detail
    ) {
        try {
            PatchDetailReq patchDetailReq = new PatchDetailReq(detail.getCategoryId(),detail.getMemo(),detail.getIsBudgetIncluded());
            detailService.modifyDetail(userId, detailId, patchDetailReq);

            String result = "상세 내역이 수정되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
