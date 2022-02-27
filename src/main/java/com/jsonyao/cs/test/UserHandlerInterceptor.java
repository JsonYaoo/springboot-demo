package com.jsonyao.cs.test;

import com.alibaba.fastjson.JSONObject;
import com.jsonyao.cs.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("preHandle");

        UserBodyWrapper userBodyWrapper = (UserBodyWrapper) request;
        String body = userBodyWrapper.getBody();

        User user = JSONObject.parseObject(body, User.class);
        user.setUsername("测试添加前缀" + user.getUsername());
        ((UserBodyWrapper) request).setBody(JSONObject.toJSONString(user));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("afterCompletion");
    }
}
