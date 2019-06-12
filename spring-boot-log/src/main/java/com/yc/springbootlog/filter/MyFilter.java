package com.yc.springbootlog.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/6/6 - 11:06
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("过滤器......");
//        chain.doFilter(request, response);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("过滤器.......");
    }

    @Override
    public void destroy() {

    }
}
