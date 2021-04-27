package com.waylau.spring.cloud.weather.controller;

import com.waylau.spring.cloud.weather.service.WeatherDataService;
import com.waylau.spring.cloud.weather.vo.Root;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 09:35
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

    /**
     * 解析xml报文，转化为对象
     * @param string
     * @return
     */
    @PostMapping(value = "/message", consumes = "application/xml")
    public Root xmlToBean(@RequestBody String string){
        Root rootInfo=new Root();
        try {
            JAXBContext  jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            rootInfo = (Root) unmarshaller.unmarshal (new StringReader (string));
        } catch (JAXBException e) {
            e.printStackTrace ();
        }

        return rootInfo;
    }
}
