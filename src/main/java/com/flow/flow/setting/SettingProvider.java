
package com.flow.flow.setting;

import com.flow.flow.config.BaseException;
import com.flow.flow.model.Form;
import com.flow.flow.model.GetFormRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.flow.flow.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class SettingProvider {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SettingDao settingDao;

    @Autowired
    public SettingProvider(SettingDao settingDao) {
        this.settingDao = settingDao;
    }


    public GetFormRes getForm(String bankName) throws BaseException {
        try{
            List<Form> form = settingDao.getForm(bankName);
            GetFormRes getFormRes = new GetFormRes(bankName, form);

            return getFormRes;
        } catch(Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
