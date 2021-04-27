package com.waylau.spring.cloud.weather.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 08:29
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;
    public Weather getData() {
        return data;
    }
    public void setData(Weather data) {
        this.data = data;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
