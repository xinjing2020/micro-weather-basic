package com.waylau.spring.cloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 10:33
 **/
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build ();
    }
}
