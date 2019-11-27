package com.toshiba.assetmgmtapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        UserContextHolder
                .getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        System.out.println("***************");
        System.out.println(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        System.out.println(">>>> "+UserContextHolder.getContext().getCorrelationId());
        System.out.println("***************");
        filterChain
                .doFilter(httpServletRequest, servletResponse);
    }
}