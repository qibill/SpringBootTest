package com.qibill.controller;

import com.qibill.common.utils.BindingResultUtil;
import com.qibill.vo.ParameterVo;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ParameterController {

    private static final Logger LOGGER = Logger.getLogger(ParameterController.class);

    @ResponseBody
    @RequestMapping(value = "/parameter/test", method = RequestMethod.GET)
    public String test(ParameterVo parameterVo, BindingResult bindingResult) {
        //校验参数
        BindingResultUtil.validateParameters(bindingResult);
        return "test";
    }

}
