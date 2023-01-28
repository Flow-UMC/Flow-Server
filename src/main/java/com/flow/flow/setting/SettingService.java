package com.flow.flow.setting;

import com.flow.flow.config.BaseException;
import com.flow.flow.model.PatchBudgetReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.flow.flow.config.BaseResponseStatus.*;

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

    public void resetData(int userId) throws BaseException{
        try{
            int result = settingDao.resetData(userId);
            if(result == 0){
                throw new BaseException(RESET_FAIL);
            }
        } catch(Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void deleteUser(int userId) throws BaseException{
        try{
            int result = settingDao.deleteUser(userId);
            if(result == 0){
                throw new BaseException(RESET_FAIL);
            }
        } catch(Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
