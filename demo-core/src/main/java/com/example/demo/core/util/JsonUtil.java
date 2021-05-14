package com.example.demo.core.util;

public class JsonUtil {

    public static void main(String[] args){
        String jsonStr = "{\"properties\":{\"author\":{\"type\":\"keyword\"},\"title\":{\"type\":\"text\"},\"content\":{\"type\":\"text\"},\"price\":{\"type\":\"integer\"},\"date\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd HH:mm:ss\"}}}";
        System.out.println(jsonStr);
    }
}
