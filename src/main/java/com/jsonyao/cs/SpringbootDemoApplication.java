package com.jsonyao.cs;

import com.jsonyao.cs.controller.UserController;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Ralation:
 *      a. https://www.jianshu.com/p/52bd327568b9
 */
@SpringBootApplication
// proxyTargetClass默认为false, 表示默认使用JDK 动态代理, 碰到接口或者设置为true, 则使用CGLIB动态代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringbootDemoApplication implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserController bean = event.getApplicationContext().getBean(UserController.class);
        System.err.println(bean);
    }
}
