package com.jsonyao.cs.test;

import com.jsonyao.cs.test.UserHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc拦截器配置类
 *
 * @author yaocs2@midea.com
 * @since 2021-04-01
 */
@Configuration
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserHandlerInterceptor()).addPathPatterns("/**");
    }
}
