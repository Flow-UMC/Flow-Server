package com.flow.flow.src.setting;

import com.flow.flow.config.BaseException;
import com.flow.flow.src.setting.model.Form;
import com.flow.flow.src.setting.model.GetFormReq;
import com.flow.flow.src.setting.model.GetFormRes;
import com.flow.flow.src.setting.model.PatchBudgetReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.flow.flow.config.BaseResponseStatus.DATABASE_ERROR;
import static com.flow.flow.config.BaseResponseStatus.MODIFY_FAIL_BUDGET;

@Service
public class SettingService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SettingDao settingDao;

    @Autowired
    public SettingService(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    public void modifyBudget(int userId, PatchBudgetReq patchBudgetReq) throws BaseException{
        try{
            int result = settingDao.modifyBudget(userId, patchBudgetReq);
            if(result == 0){
                throw new BaseException(MODIFY_FAIL_BUDGET);
            }
        } catch(Exception exception) {
            throw new BaseException(DATABASE_ERROR);
    }
    }

}
