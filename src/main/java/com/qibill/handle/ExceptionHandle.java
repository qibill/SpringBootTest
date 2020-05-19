package com.qibill.handle;


import com.qibill.common.pojo.MyResult;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 *  异常拦截器
 * @author qibill
 * @date 2018/11/22 11:09
 **/
@RestControllerAdvice
public class ExceptionHandle {

	private static final Logger LOGGER = Logger.getLogger(ExceptionHandle.class);

	/**
	 * 校验错误拦截处理
	 *
	 * @param bindException
	 * @return {@link MyResult}
	 */
	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public MyResult handleHttpBindException(BindException bindException) {
		BindingResult bindingResult = bindException.getBindingResult();
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			StringBuilder msg = new StringBuilder();
			for (ObjectError objectError : errors) {
				FieldError fieldError = (FieldError) objectError;
				LOGGER.error(String.format("数据校验失败 : 对象【%s】中的【%s】的属性校验错误，信息为：[%s]",
						fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage()));
				msg.append(objectError.getDefaultMessage());
				msg.append(';');

			}
			return MyResult.fail(msg.toString());
		}
		return MyResult.fail(bindException);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MyResult handle(Exception e) {
		LOGGER.fatal("参数错误", e);
		return MyResult.fail(e);
	}
}
