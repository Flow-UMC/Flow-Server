package com.flow.oauth.config;

import com.flow.oauth.domain.CustomOAuthUser;
import com.flow.oauth.domain.SessionUser;
import com.flow.user.domain.User;
import com.flow.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomOAuthSuccessHandler implements AuthenticationSuccessHandler {
    private final UserService userService;
    private final HttpSession httpSession;

    @Autowired
    public CustomOAuthSuccessHandler(UserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomOAuthUser oAuthUser = (CustomOAuthUser) authentication.getPrincipal();
        User user = oAuthUser.getUser();
        boolean join = oAuthUser.isJoin();

        httpSession.setAttribute("user", new SessionUser(user));

        if (join) {
            userService.save(user);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/join");
        }
    }
}
