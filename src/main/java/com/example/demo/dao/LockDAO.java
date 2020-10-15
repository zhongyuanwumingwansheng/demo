package com.example.demo.dao;

import com.example.demo.model.LockDO;

/**
 * 锁dao
 */
public interface LockDAO {
    /**
     *
     * @param lockName
     * @return
     */
    LockDO findLockByName(String lockName);

    /**
     *
     * @param lockDO
     * @return
     */
    Boolean insert(LockDO lockDO);

    /**
     *
     * @param lockDO
     * @return
     */
    Boolean update(LockDO lockDO);

    /**
     *
     * @param lockDO
     * @return
     */
    Boolean delete(LockDO lockDO);
}
