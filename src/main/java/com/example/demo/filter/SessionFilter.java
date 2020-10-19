package com.example.demo.filter;

import com.example.demo.context.EnvService;
import com.example.demo.context.ThreadContext;
import com.example.demo.util.ThreadContextUtil;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SessionFilter extends OncePerRequestFilter implements Filter {

    private EnvService envService;
    private List<String> excludeUrls;

    private CookieLocaleResolver localeResolver;


    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException{
        HttpSession httpSession = servletRequest.getSession();
        ThreadContext context = envService.buildContextFromSession(httpSession, servletRequest);

        if(null == context){
            //重定向
            String redirectUrl = "";
            //重定向 adapter

            if(servletRequest.getRequestURI().contains("/index.htm")){
                servletResponse.sendRedirect(redirectUrl);
            }
        }

        if(context!=null){
            //一些准备工作
            //处理cookie
            updateCookies(servletResponse, context);
            //处理locale
            ThreadContextUtil.setContext(context);
        }

        //判定是否过滤
        try{
            if(doFilter(servletRequest, context)){
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            throw new RuntimeException();
        } finally {
            ThreadContextUtil.clearContext();
        }


    }

    private Boolean doFilter(HttpServletRequest servletRequest, ThreadContext threadContext){
        String requestUri = servletRequest.getRequestURI();
        if(excludeUrls.contains(requestUri)){
            return false;
        } else {
            if(threadContext.getAccess()){
                return false;
            }
        }
        return true;

    }

    private void updateCookies(HttpServletResponse servletResponse, ThreadContext threadContext){
        //从threadContext中提取一些信息，放入cookie中
        Cookie cookie = new Cookie("tenantUid",threadContext.getBaseId());
        servletResponse.addCookie(cookie);

    }


}
