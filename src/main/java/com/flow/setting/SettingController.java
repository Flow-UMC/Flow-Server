package com.flow.setting;

import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import com.flow.model.GetFormReq;
import com.flow.model.GetFormRes;
import com.flow.model.PatchBudgetReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class SettingController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final SettingService settingService;
    private final SettingProvider settingProvider;

    public SettingController(SettingService settingService, SettingProvider settingProvider) {
        this.settingService = settingService;
        this.settingProvider = settingProvider;
    }

    /**
     * 예산 금액과 시작일 수정
     * [PATCH] /users/modifyBudget
     */
    @ResponseBody
    @PatchMapping("/modifyBudget")
    public BaseResponse<String> modifyBudget(@RequestBody PatchBudgetReq patchBudgetReq, @RequestParam("userId") int userId){
        try {
            settingService.modifyBudget(userId, patchBudgetReq);

            String result = "예산이 수정되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 은행앱 추가 선택
     * [GET] /users/selectForm
     */
    @ResponseBody
    @GetMapping("/selectForms")
    public BaseResponse<List<GetFormRes>> selectForm(@RequestBody GetFormReq getFormReq){
        try {
            List<GetFormRes> getFormRes = new ArrayList<>();
            for(String s: getFormReq.getBankName()){
                System.out.println(s);
                GetFormRes formList = settingProvider.getForm(s);
                getFormRes.add(formList);
            }

            return new BaseResponse<>(getFormRes);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 모든 데이터 삭제
     * [DELETE] /users/reset
     */
    @ResponseBody
    @DeleteMapping("/reset")
    public BaseResponse<String> resetData(@RequestParam("userId") int userId){
        try{
            settingService.resetData(userId);

            String result = "모든 거래내역이 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 회원 탈퇴
     * [DELETE] users/deleteUser
     */
    @ResponseBody
    @DeleteMapping("/deleteUser")
    public BaseResponse<String> deleteUser(@RequestParam("userId") int userId){
        try{
            settingService.deleteUser(userId);

            String result = "회원 탈퇴하였습니다.";
            return new BaseResponse<>(result);
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
