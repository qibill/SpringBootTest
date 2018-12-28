package com.qibill.format;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@Component
public class MyDateTimeFormatValidator implements ConstraintValidator<MyDateTimeFormat, Date> {

    @Override
    public void initialize(MyDateTimeFormat myDateTimeFormat) {
        System.out.println("初始化校验器");
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        //校验的逻辑
        return !new Date(0).equals(date);
    }
}
