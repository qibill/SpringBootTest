package com.qibill.config;

import com.qibill.factory.JobBeanFactory;
import com.qibill.job.QuartzJob;
import org.quartz.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qibill
 * @date 2019/8/29 11:27
 **/
@Configuration
public class QuartzConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 使用jobDetail包装job
     * @return
     */
    @Bean
    public JobDetail zhiyeSampleJobDetail() {
        return JobBuilder.newJob(QuartzJob.class).withIdentity("ZhiyeSampleJob").storeDurably().build();
    }

    /**
     * 把jobDetail注册到trigger上去
     * @return
     */
    @Bean
    public Trigger sampleJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0 * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(zhiyeSampleJobDetail())
                .withIdentity("sampleJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @Bean
    public SchedulerFactoryBeanCustomizer schedulerFactoryBeanCustomizer() {
        return schedulerFactoryBean -> schedulerFactoryBean.setJobFactory(new JobBeanFactory(applicationContext));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
