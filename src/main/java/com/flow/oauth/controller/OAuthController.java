package com.flow.oauth.controller;

import com.flow.user.domain.User;
import com.flow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OAuthController {
    private final UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/join", method = {RequestMethod.GET})
    public String join() {
        return "join";
    }

    @RequestMapping(value = "/join/ok", method = {RequestMethod.GET})
    public void join(Authentication authentication, HttpServletResponse response) throws IOException {
        User user = userService.join(authentication);
        if (user.getId() == null) {
            response.sendError(500, "회원 가입 실패");
        }
        response.sendRedirect("/");
    }
}
