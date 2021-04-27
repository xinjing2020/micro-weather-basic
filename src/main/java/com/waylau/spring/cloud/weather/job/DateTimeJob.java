package com.waylau.spring.cloud.weather.job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 16:59
 * 具体的业务逻辑代码写在这里
 **/
public class DateTimeJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(DateTimeJob.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
      logger.info ("定时任务开始了");
    }
}
