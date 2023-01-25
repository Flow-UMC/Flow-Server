package com.flow.flow.calendar;

import com.flow.flow.calendar.model.GetCalendarRes;
import com.flow.flow.calendar.model.GetTotalAmount;
import com.flow.flow.calendar.model.GetTranByDateRes;
import com.flow.flow.calendar.model.Transaction;
import com.flow.flow.config.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.flow.flow.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class CalendarProvider {

    private final CalendarDao calendarDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CalendarProvider(CalendarDao calendarDao) {
        this.calendarDao = calendarDao;
    }


    public List<GetCalendarRes> getCalendar(int year, int month, int userId) throws BaseException {
        try{
            List<GetCalendarRes> getCalendarRes = calendarDao.getCalendar(year, month, userId);
            return getCalendarRes;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public GetTranByDateRes getTranByDate(int year, int month, int date, int userId) throws BaseException{
        try{
            List<Transaction> transaction = calendarDao.getTransaction(year, month, date, userId);
            List<GetTotalAmount> getTotalAmount = calendarDao.getTotalAmount(year, month, date, userId);
            GetTranByDateRes getTranByDateRes = new GetTranByDateRes(getTotalAmount, transaction) ;
            return getTranByDateRes;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
    public List<Transaction> getTransaction(int year, int month, int date, int userId) throws BaseException{
        try{
            List<Transaction> transaction = calendarDao.getTransaction(year, month, date, userId);
            return transaction;
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

}

