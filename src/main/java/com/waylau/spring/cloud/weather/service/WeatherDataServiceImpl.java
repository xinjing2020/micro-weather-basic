package com.waylau.spring.cloud.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 08:37
 **/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private  static  final long  TIME_OUT =1800L; //1800s
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeahter(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
       String url = WEATHER_URI+"city="+cityName;
        return this.doGetWeahter (url);
    }
    private WeatherResponse doGetWeahter(String url) {
        String key = url;
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis数据获取中。。。");
            strBody = ops.get(key);
        } else {
            logger.info("Redis 数据获取失败。。。");
            // 缓存没有，再调用服务接口来获取
            ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);

            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
            }

            // 数据写入缓存
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("不好意思Error!",e);
        }
        return resp;
    }
    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }
    /**
     * 把天气数据放在缓存
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();

        // 调用服务接口来获取
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        // 数据写入缓存
        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

    }

    }


