package com.waylau.spring.cloud.weather.config;

import com.waylau.spring.cloud.weather.job.DateTimeJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 17:01
 **/
@Configuration
public class QuartzConfig {
    private static final int TIME = 50; // 更新频率

    @Bean
    public JobDetail weatherDataSyncJobDetail() {

        return JobBuilder.newJob (DateTimeJob.class)
                .withIdentity ("DateTimeJob") //可以给该JobDetail起一个id
                .storeDurably ()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build ();
    }
    @Bean
    public Trigger printTimeJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder  = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME) //重复时间间隔
                .repeatForever ();
        return TriggerBuilder.newTrigger ()
                .forJob(weatherDataSyncJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule (simpleScheduleBuilder)
                .build ();
    }
}
