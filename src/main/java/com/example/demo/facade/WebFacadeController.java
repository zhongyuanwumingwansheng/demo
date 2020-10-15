package com.example.demo.facade;

import com.example.demo.model.ResponseEntity;
import com.example.demo.util.SecretUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class WebFacadeController {

    public ResponseEntity webFacade(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    String bizType, String sign, String ts, String appKey){
        Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
        //将requestParams解析为Map<String, Object>params
        Map<String, Object> params = new HashMap<>();
        String path = httpServletRequest.getRequestURI();

        //检查时间戳

        //通过appKey得到对应的secretKey
        //TODO
        String secretKey = "";
        String expSign = SecretUtil.sign(path, params, secretKey);
        if(!StringUtils.equals(expSign, sign)){
            return null;
        }

        //根据传入的参数做业务
        return null;
    }
}
