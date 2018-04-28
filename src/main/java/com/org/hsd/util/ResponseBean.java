package com.org.hsd.util;

import com.alibaba.fastjson.JSONObject;

/**
 * restful风格api统一返回格式
 */
public class ResponseBean {
    /**
     * 返回封装
     * @param status
     * @param message
     * @param result
     * @return
     */
    public static String resultString(Integer status, String message, Object result){
        JSONObject jsonObject = new JSONObject(){{
            put("status", status);
            put("message", message);
            put("result", result);
        }};
        return jsonObject.toString();
    }

}
