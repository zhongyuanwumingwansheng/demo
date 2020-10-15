package com.example.demo.model;

import java.io.Serializable;

public class RiskScanResult<T> implements Serializable {
    //private static final long

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误信息
     */
    private String resultMsg;

    private T data;
}
