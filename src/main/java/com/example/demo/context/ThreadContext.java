package com.example.demo.context;

import java.util.Locale;

/**
 * 上下文信息
 */
public class ThreadContext {
    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Boolean getAccess() {
        return isAccess;
    }

    public void setAccess(Boolean access) {
        isAccess = access;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * 用户名称
     */
    private String baseId;

    /**
     * 租户名称
     */
    private String tenantId;

    /**
     * 是否可以访问
     */
    private Boolean isAccess;

    /**
     *  请求所在环境
     */
    private Locale locale;
}
