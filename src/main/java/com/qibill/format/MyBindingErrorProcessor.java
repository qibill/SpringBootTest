package com.qibill.format;

import org.springframework.beans.PropertyAccessException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.*;

/**
 * @description:
 * @author: qibill
 * @date: 2018/12/28 14:08
 **/
@Component
public class MyBindingErrorProcessor extends DefaultBindingErrorProcessor {

    public MyBindingErrorProcessor() {
        System.out.println("======自定义BindingErrorProcessor=======");
    }

    @Override
    public void processPropertyAccessException(PropertyAccessException ex, BindingResult bindingResult) {
        // Create field error with the exceptions's code, e.g. "typeMismatch".
        String field = ex.getPropertyName();
        Assert.state(field != null, "No field in exception");
        String[] codes = bindingResult.resolveMessageCodes(ex.getErrorCode(), field);
        Object[] arguments = getArgumentsForBindError(bindingResult.getObjectName(), field);
        Object rejectedValue = ex.getValue();
        if (ObjectUtils.isArray(rejectedValue)) {
            rejectedValue = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(rejectedValue));
        }
        //TODO
        FieldError error = new FieldError(bindingResult.getObjectName(), field, rejectedValue, true,
                codes, arguments, "干死黄旭东");
        error.wrap(ex);
        bindingResult.addError(error);
    }

}
