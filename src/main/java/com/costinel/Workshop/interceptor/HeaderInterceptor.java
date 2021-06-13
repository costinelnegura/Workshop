package com.costinel.Workshop.interceptor;

import com.costinel.Workshop.jdbc.dao.ClaimDao;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

    private ClaimDao claimDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        request.setAttribute("welcomeMessage", "Welcome to Workshop!");

        return true;
    }
}
