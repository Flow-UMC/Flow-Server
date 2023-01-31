package com.flow.calendar;

import com.flow.model.GetCalendarRes;
import com.flow.model.GetTranByDateRes;
import com.flow.model.Pagination;
import com.flow.model.Transaction;
import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final CalendarProvider calendarProvider;

    public CalendarController(CalendarProvider calendarProvider) {
        this.calendarProvider = calendarProvider;
    }

    /**
     * 캘린더에서 날짜 별 총 지출, 수입 금액 조회
     * [GET] /calendar/:year/:month
     */
    @ResponseBody
    @GetMapping("/{year}/{month}")
    public BaseResponse<List<GetCalendarRes>> getCalendar(@PathVariable("year") String year, @PathVariable("month") String month, @RequestParam("userId") int userId) {
        try {
            List<GetCalendarRes> getCalendarRes = calendarProvider.getCalendar(year, month, userId);
            return new BaseResponse<>(getCalendarRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 날짜별 전체 내역 조회
     * [GET] /calendar/:year/:month/:date
     */
    @ResponseBody
    @GetMapping("/{year}/{month}/{date}")
    public BaseResponse<GetTranByDateRes> getTranByDate(@PathVariable("year") String year, @PathVariable("month") String month,
                                                        @PathVariable("date") String date, @RequestParam("userId") int userId) {
        try {
            GetTranByDateRes getTranByDateRes = calendarProvider.getTranByDate(year, month, date, userId);
            return new BaseResponse<>(getTranByDateRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}


