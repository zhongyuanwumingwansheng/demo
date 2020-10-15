package com.example.demo.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface EnvService {
    ThreadContext buildContextFromSession(HttpSession httpSession, HttpServletRequest servletRequest);
}
