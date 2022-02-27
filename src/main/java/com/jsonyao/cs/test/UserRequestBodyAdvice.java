package com.jsonyao.cs.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

@ControllerAdvice
public class UserRequestBodyAdvice implements RequestBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("supports");
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        System.err.println("beforeBodyRead");
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("afterBodyRead");

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(body));
        Long id = jsonObject.getLong("id");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        try {
            Constructor constructor = ((Class) targetType).getConstructor(Long.class, String.class, String.class);
            return constructor.newInstance(id, username + "测试添加后缀", password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("handleEmptyBody");
        return body;
    }
}
