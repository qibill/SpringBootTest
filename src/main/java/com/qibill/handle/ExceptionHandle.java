package com.qibill.handle;


import com.qibill.common.pojo.MyResult;
import com.qibill.exception.DatabaseDataException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 异常拦截器
 * @author: qibill
 * @date: 2018/11/22 11:09
 **/
@RestControllerAdvice
public class ExceptionHandle {

	private static final Logger LOGGER = Logger.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = DatabaseDataException.class)
	@ResponseBody
	public MyResult handle(DatabaseDataException e) {
		LOGGER.error("数据库数据异常", e);
		return MyResult.fail(e);
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseBody
	public MyResult handle(IllegalArgumentException e) {
		LOGGER.fatal("参数错误", e);
		return MyResult.fail(e);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MyResult handle(MethodArgumentNotValidException e) {
		LOGGER.fatal("参数错误", e);
		return MyResult.fail(e);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MyResult handle(Exception e) {
		LOGGER.fatal("参数错误", e);
		return MyResult.fail(e);
	}
}
