package com.qibill.common.utils;


import com.qibill.format.MyDateTimeFormat;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Field;

/**
 * @description: springboot 校验参数的公用工具类
 * @author: qibill
 * @date: 2018/12/18 9:45
 **/
public class BindingResultUtil {

    private static final Logger LOGGER = Logger.getLogger(BindingResultUtil.class);
    /**
     * 公用事业类不应该有公共构造函数
     */
    private BindingResultUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateParameters( BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()){
                LOGGER.fatal(error.getClass());
                msg.append(error.getDefaultMessage());
                msg.append(';');
            }
            throw new IllegalArgumentException(msg.toString());
        }
    }

}
