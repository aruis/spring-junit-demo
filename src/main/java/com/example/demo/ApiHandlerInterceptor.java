package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String host = request.getRemoteHost();
        String httpVersion = request.getProtocol();
        String referrer = request.getHeader("Referer");
        String userAgent = request.getHeader("User-Agent");

        String sql = "insert into log_http (v_method, v_uri, v_host, v_http_version, v_referrer, v_user_agent) values (?,?,?,?,?,?);";
        jdbcTemplate.update(sql, method, uri, host, httpVersion, referrer, userAgent);

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
