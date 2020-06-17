package com.qibill.config;

import com.qibill.webservice.SjfyEhrUploadNewSoap;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qibill
 * @date 2019/9/25 11:33
 **/
@Configuration
public class CxfConfig {

    @Bean
    public SjfyEhrUploadNewSoap sjfyEhrUploadNewSoap() {
        String address = "http://117.25.173.18:2011/SjfyEhrUploadNew.asmx";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(SjfyEhrUploadNewSoap.class);
        // 创建一个代理接口实现
        return  (SjfyEhrUploadNewSoap) jaxWsProxyFactoryBean.create();
    }
}
