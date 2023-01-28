package com.flow.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flow.config.BaseException;
import com.flow.config.BaseResponse;
import com.flow.model.GetHomeRes;

@RestController
@RequestMapping("/home")

public class HomeController {
    
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final HomeProvider homeProvider;

    public HomeController(HomeProvider homeProvider) {
        this.homeProvider = homeProvider;
    }
    
    // @Autowired
    // private final HomeService homeService;
    
    // public HomeController(HomeProvider homeProvider, HomeService homeService) {
    //     this.homeProvider = homeProvider;
    //     this.homeService = homeService;
    // }

    //홈 조회 API
    // [GET] /home/:userId/:month
    @ResponseBody
    @GetMapping("/{userId}/{month}")
    public BaseResponse<GetHomeRes> getHome(@PathVariable("userId") int userId, @PathVariable("month") int month) {
        try {
            GetHomeRes getHomeRes = homeProvider.getHome(userId, month);
            return new BaseResponse<>(getHomeRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}