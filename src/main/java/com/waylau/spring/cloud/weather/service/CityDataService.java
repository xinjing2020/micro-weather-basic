package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 21:48
 **/
public interface CityDataService {
    public List<City> listCity() throws Exception;
}
