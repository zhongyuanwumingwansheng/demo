package com.example.demo.context;

import com.example.demo.model.ProcessResult;

import java.util.HashMap;
import java.util.Map;

public class ProcessContext<T> {
    /**
     * 输入
     */
    private T input;

    /**
     * 业务代号
     */
    private String scene;

    /**
     * 处理结果
     */
    private ProcessResult processResult;

    /**
     * 处理的业务对象
     */
    private Object bizObject;

    /**
     * 本地上下文
     */
    private Map<String, Object> localContext = new HashMap<>();
}
