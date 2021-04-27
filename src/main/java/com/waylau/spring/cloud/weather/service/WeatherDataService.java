package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 08:34
 **/
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncDateByCityId(String cityId);
}
