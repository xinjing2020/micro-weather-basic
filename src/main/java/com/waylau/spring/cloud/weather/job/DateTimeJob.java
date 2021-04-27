package com.waylau.spring.cloud.weather.job;
import com.waylau.spring.cloud.weather.service.CityDataService;
import com.waylau.spring.cloud.weather.service.WeatherDataService;
import com.waylau.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 16:59
 * 具体的业务逻辑代码写在这里
 **/
public class DateTimeJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(DateTimeJob.class);
    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
      logger.info ("定时任务开始了");
        // 获取城市ID列表
        List<City> list=null;
        try {
             list = cityDataService.listCity ();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        for (City city :list){
            String cityId = city.getCityId();
            logger.info("开始获取城市:" + cityId);

            weatherDataService.getDataByCityId (cityId);
        }
        logger.info("Weather Data Sync Job. End！");
    }
}
