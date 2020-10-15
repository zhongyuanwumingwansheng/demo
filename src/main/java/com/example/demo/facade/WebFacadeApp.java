package com.example.demo.facade;

public class WebFacadeApp {
    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 应用名
     */
    private String appKey;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 应用描述
     */
    private String desc;
}
