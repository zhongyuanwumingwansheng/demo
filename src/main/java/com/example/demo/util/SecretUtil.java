package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecretUtil {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String sign(String apiPath, Map<String, Object>params, String secretKey){
        //一系列的计算，计算出sign的值
        StringBuilder sb = new StringBuilder();
        //加入apiPath
        sb.append(apiPath);
        //将params转换为k+"_"+v格式的value，
        sb.append(params.toString());
        //转换为string
        String str = sb.toString();

        try{
            //HMACSHA加密
            byte[] datas = HmacSHA1Encrypt(str, secretKey);

            //hex转换，转换为string
            String sign = String.valueOf(encodeHex(datas, DIGITS_UPPER));
            return sign;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception
    {
        byte[] data=encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作
        mac.update(text, 0, text.length);
        return mac.doFinal(text);
    }

    private static char[] encodeHex(final byte[] data, final char[] toDigits){
        final int l = data.length;
        final char[] out = new char[l << 1];
        for(int i=0,j =0;i<l;i++){
            out[j++] = toDigits[0xF0 & data[i] >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

}
