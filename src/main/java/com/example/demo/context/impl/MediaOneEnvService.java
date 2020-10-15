package com.example.demo.context.impl;

import com.example.demo.context.ThreadContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MediaOneEnvService {
    ThreadContext buildContextFromSession(HttpSession httpSession, HttpServletRequest servletRequest){
        String cmTicket = servletRequest.getParameter("cmTicket");
        String sessionId = getCookie(servletRequest, "tenantUid");

        //做业务，调用sessionservice
        return null;
    }

    private String getCookie(HttpServletRequest servletRequest, String key){
        Cookie[] cookies = servletRequest.getCookies();
        for(Cookie cookie:cookies){
            if(StringUtils.equals(cookie.getName(), key)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
