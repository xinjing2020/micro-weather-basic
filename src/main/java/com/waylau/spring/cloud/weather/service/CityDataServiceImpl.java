package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.util.XmlBuilder;
import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 21:58
 **/
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        ClassPathResource pathResourcepathResource = new ClassPathResource ("citylist.xml");
        BufferedReader br = new BufferedReader (new InputStreamReader (pathResourcepathResource.getInputStream (), "utf-8"));
        StringBuffer buffer = new StringBuffer ();
        String line = "";

        while ((line = br.readLine ()) != null) {
            buffer.append (line);
        }

        br.close ();

        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject (CityList.class, buffer.toString ());
        return cityList.getCityList ();

    }
}
