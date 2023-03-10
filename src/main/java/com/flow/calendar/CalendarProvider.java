package com.flow.calendar;

import com.flow.model.*;
import com.flow.config.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.flow.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class CalendarProvider {

    private final CalendarDao calendarDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CalendarProvider(CalendarDao calendarDao) {
        this.calendarDao = calendarDao;
    }


    public List<GetCalendarRes> getCalendar(String year, String month, int userId) throws BaseException {
        try{
            List<GetCalendarRes> getCalendarRes = calendarDao.getCalendar(year, month, userId);
            return getCalendarRes;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public GetTranByDateRes getTranByDate(String year, String month, String date, int userId) throws BaseException{
        try{
            List<Detail> detail = calendarDao.getDetail(year, month, date, userId);
            List<GetTotalAmount> getTotalAmount = calendarDao.getTotalAmount(year, month, date, userId);
            GetTranByDateRes getTranByDateRes = new GetTranByDateRes(getTotalAmount, detail);
            return getTranByDateRes;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
}

