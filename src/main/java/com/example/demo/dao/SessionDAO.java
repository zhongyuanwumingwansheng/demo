package com.example.demo.dao;

import com.example.demo.model.SessionDO;

import java.util.List;

public interface SessionDAO {
    /**
     * 插入session
     * @param sessionDO
     * @return
     */
    boolean insert(SessionDO sessionDO);

    /**
     * 通过id查找session
     */
    SessionDO queryById(String sessionId);

    /**
     * 查找所有要失效的session
     * @return
     */
    List<SessionDO> queryAllExpiredSession();

    /**
     * 失效所有session
     * @return
     */
    int updateAllExpiredSession();
}
