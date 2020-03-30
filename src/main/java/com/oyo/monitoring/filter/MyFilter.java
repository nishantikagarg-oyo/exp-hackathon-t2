package com.oyo.monitoring.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        UUID uid = UUID.randomUUID();
        String s=uid.toString();

        res.setHeader("Example-Filter-Header", s);

//        System.out.println("Request URI is: " + req.getRequestURI());
        chain.doFilter(request, response);
//        System.out.println("Response Status Code is: " + res.getStatus());
        System.out.println(res.getHeader("Example-Filter-Header"));
    }

}