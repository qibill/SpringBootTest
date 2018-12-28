package com.qibill.exception;

/**
 * @description: 数据库数据异常类
 * @author: qibill
 * @date: 2018/11/22 10:34
 **/
public class DatabaseDataException extends RuntimeException {

	public DatabaseDataException(String message) {
		super(message);
	}
}
