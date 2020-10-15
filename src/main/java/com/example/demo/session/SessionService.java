package com.example.demo.session;

import com.example.demo.model.SessionDO;

import java.util.Map;

public interface SessionService {
    boolean addSession(String sessionId, Map<String, String> sessionVal);

    boolean addSession(SessionDO sessionDO);

    SessionDO querySession(String sessionId);

    int expireSession();
}
