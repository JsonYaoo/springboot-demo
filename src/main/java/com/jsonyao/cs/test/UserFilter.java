package com.jsonyao.cs.test;

import org.apache.catalina.connector.ResponseFacade;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("init");
    }

    @Override
    public void destroy() {
        System.err.println("destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ((ResponseFacade) response).addHeader("sign", request.getParameter("sign"));
        System.err.println("doFilter");
        chain.doFilter(new UserBodyWrapper((HttpServletRequest) request), response);
    }
}
