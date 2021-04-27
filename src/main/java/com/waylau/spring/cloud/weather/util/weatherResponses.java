package com.waylau.spring.cloud.weather.util;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 20:14
 **/
public class weatherResponses {
    private Integer code;
    private String type;
    private String message;


    public weatherResponses(Integer code, String type, String  message) {
        this.code = code;
        this.type = type;
        this.message =  message;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
