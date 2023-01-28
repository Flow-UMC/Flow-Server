package com.flow.detail;

import com.flow.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import static com.flow.config.BaseResponseStatus.*;
import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {
    
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
        Pagination pagination = new Pagination();
        pagination.setPage(page);
        List<Detail> details=detailProvider.getDetails(pagination, userId, year, month);
        return new BaseResponse<>(details);
    }

    @ResponseBody
    @PostMapping("/{userId}")
    public BaseResponse<String> postDetail(@PathVariable("userId") int userId, @RequestBody Detail detail){
        if(userId==detail.getUserId()){
            detailService.postDetail(detail);
            String result="거래 내역을 생성하였습니다.";
            return new BaseResponse<>(result);
        } else{
            return new BaseResponse<>(CHECK_USER_ID);
        }
    }

    @ResponseBody
    @PatchMapping("/{userId}/join")
    public BaseResponse<String> joinDetail(@PathVariable("userId") int userId, @RequestBody GetJoinDetailReq detailIds){
        GetJoinDetailRes getJoinDetailRes = new GetJoinDetailRes(userId, detailIds.getIntegratedId(), detailIds.getDetailId());
        detailService.joinDetail(getJoinDetailRes);
        String result="detailId가 ";
        for(int id:detailIds.getDetailId()){
            result+=Integer.toString(id)+",";
        }
        result=result.substring(0,result.length()-1);
        result+="인 내역들의 대표id를 "+Integer.toString(detailIds.getIntegratedId())+"로 업데이트하였습니다.";
        return new BaseResponse<>(result);
    }

    @ResponseBody
    @DeleteMapping("/{userId}")
    public BaseResponse<String> deleteDetail(@PathVariable("userId") int userId, @RequestBody GetDeleteDetailReq detailIds){

        GetDeleteDetailRes getDeleteDetailRes = new GetDeleteDetailRes(userId, detailIds.getDetailId());
        detailService.deleteDetail(getDeleteDetailRes);
        String result="detailId가 ";
        for(int id:detailIds.getDetailId()){
            result+=Integer.toString(id)+",";
        }
        result=result.substring(0,result.length()-1);
        result+="인 내역을 삭제하였습니다.";
        return new BaseResponse<>(result);

    }
}
