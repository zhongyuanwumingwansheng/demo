package com.example.demo.model;

import java.util.Date;

public class LockDO {
    /**
     * id
     */
    private Long id;

    /**
     * 资源名称
     */
    private String lockName;

    /**
     * 主机
     */
    private String lockHost;

    /**
     * 锁的版本号
     */
    private Integer lockVersion;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 过期时间
     */
    private Date expiredTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public String getLockHost() {
        return lockHost;
    }

    public void setLockHost(String lockHost) {
        this.lockHost = lockHost;
    }

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}
