package com.waylau.spring.cloud.weather.vo;


import java.io.Serializable;
import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 08:00
 * 天气信息
 **/
public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
//    private String aqi;
    private Yesterday yesterday;
    private List<Forecast> forecast;
    private String ganmao;
    private String wendu;
//    public String getAqi() {
//        return aqi;
//    }
//    public void setAqi(String aqi) {
//        this.aqi = aqi;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }
}