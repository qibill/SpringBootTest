package com.qibill.common.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  Spring工具类，取出Spring容器内的Bean。
 * @author qibill
 * @date 2018/12/4 18:00
 **/
@Configuration
@Component
public class SpringUtil implements ApplicationContextAware {

    private static Logger LOGGER = Logger.getLogger(SpringUtil.class);

    /** 声明一个ApplicationContext */
    private static ApplicationContext applicationContext = null;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
        System.out.println("---获取到applicationContext---");
    }

    /** 获取ApplicationContext */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {

        return getApplicationContext().getBean(name, clazz);

    }

}
