package com.qibill.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * QuartzJob
 *
 * @author qibill
 * @date 2019/8/29 11:37
 **/
@Component
public class QuartzJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("定时任务");
    }
}