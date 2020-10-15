package com.example.demo.facade;

import com.example.demo.model.RiskScanResult;
import com.example.demo.util.SecretUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebFacadeInvokeUtil {
    private static final String API = "facade.json";
    private static final String SERVER_SITE = "https://api.data.company.com";

    public static <T> RiskScanResult<T> invoke(String appKey, String secretKey, String bizType,
                                               Map<String, Object> bizParams, int conTimeout, int readTimeout){
        //1,参数校验

        //2.处理系统参数
        Map<String, Object> params = new HashMap<>();
        params.put("appKey", appKey);
        params.put("secretKey", secretKey);
        params.put("bizType", bizType);
        //生成时间戳
        String timeStamp = String.valueOf((new Date()).getTime());
        params.put("timeStamp", timeStamp);

        //3.处理业务参数
        //生成签名
        String sign = SecretUtil.sign(API, params, secretKey);
        params.put("sign", sign);

        //触发http请求
        String path = SERVER_SITE+"/"+API;
        return null;
    }
}
