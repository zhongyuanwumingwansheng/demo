package com.example.demo.session.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.SessionDAO;
import com.example.demo.model.SessionDO;
import com.example.demo.util.LocalMemoryCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class SessionServiceImpl {

    /**
     *
     */
    @Autowired
    private SessionDAO sessionDAO;

    /**
     *
     */
    @Autowired
    private LocalMemoryCache cache;

    /**
     *
     * @param sessionId
     * @param sessionVal
     * @return
     */
    public boolean addSession(String sessionId, Map<String, String> sessionVal){
        SessionDO sessionDO = new SessionDO();
        sessionDO.setSessionId(sessionId);
        sessionDO.setSessionValue(JSON.toJSONString(sessionVal));
        sessionDO.setStatus(Integer.valueOf(1));
        //TODO, expiredTime
        //sessionDO.setExpiredTime();
        return addSession(sessionDO);
    }

    public boolean addSession(SessionDO sessionDO){
        //判空处理，
        if(sessionDO == null || StringUtils.isBlank(sessionDO.getSessionId())
        || StringUtils.isBlank(sessionDO.getSessionValue())){
            return false;
        }

        return sessionDAO.insert(sessionDO);
    }

    public SessionDO querySession(String sessionId){
        if(StringUtils.isBlank(sessionId)){
            return null;
        }

        //查找缓存
        String sessionValue = (String) this.cache.get(sessionId);

        //查找数据库
        SessionDO sessionDO = sessionDAO.queryById(sessionId);

        if(StringUtils.isBlank(sessionValue)&&sessionDO!=null){
            sessionValue = sessionDO.getSessionValue();
            cache.put(sessionId, sessionValue);
        }

        if(!StringUtils.isBlank(sessionValue)){
            SessionDO sessionDO1 = new SessionDO();
            sessionDO1.setSessionId(sessionId);
            sessionDO1.setSessionValue(sessionValue);
            return sessionDO1;
        }

        return null;
    }

    public int expireSession(){
        List<SessionDO> sessionDOList = sessionDAO.queryAllExpiredSession();

        int rows = sessionDAO.updateAllExpiredSession();
        if(rows >0){
            for(SessionDO sessionDO: sessionDOList){
                boolean flag = cache.delete(sessionDO.getSessionId());
            }
        }
        return rows;
    }
}
