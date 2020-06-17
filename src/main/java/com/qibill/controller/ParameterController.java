package com.qibill.controller;

import com.qibill.vo.ParameterVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qibill
 */
@Controller
public class ParameterController {

    private static final Logger LOGGER = Logger.getLogger(ParameterController.class);

    @ResponseBody
    @RequestMapping(value = "/parameter/test", method = RequestMethod.GET)
    public ParameterVo test(@Valid ParameterVo parameterVo) {
        System.out.println(parameterVo);
        return parameterVo;
    }

}
