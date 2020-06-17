package com.qibill.config;

import com.qibill.format.MyDateTimeFormatAnnotationFormatterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  设置类，允许跨域
 * @author qibill
 * @date 2018/12/14 16:14
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //生成图片存放在 ${tms.barcodeUrl} 文件夹下，访问路径如：http://localhost:8081/temp/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中temp表示访问的前缀。"file:" + url 是文件真实的存储路径
        registry.addResourceHandler("/download/**").addResourceLocations("file:D:/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new MyDateTimeFormatAnnotationFormatterFactory());
    }
}
