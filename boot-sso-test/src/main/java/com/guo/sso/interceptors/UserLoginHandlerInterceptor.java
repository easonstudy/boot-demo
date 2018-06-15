package com.guo.sso.interceptors;

import com.guo.sso.pojo.User;
import com.guo.sso.service.UserService;
import com.guo.sso.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginHandlerInterceptor extends HandlerInterceptorAdapter {

    public static final String COOKIE_NAME = "USER_TOKEN";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("sso test interceptor");
        try {
            String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
            User user = this.userService.getUserByToken(token);
            System.out.println("sso test token:" + token);
            if (StringUtils.isEmpty(token) || null == user) {
                // 跳转到登录页面，把用户请求的url作为参数传递给登录页面。
                response.sendRedirect("http://localhost:8081/login?redirect=" + request.getRequestURL());
                // 返回false
                return false;
            }
            // 把用户信息放入Request
            request.setAttribute("user", user);
            // 返回值决定handler是否执行。true：执行，false：不执行。
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
    }

}