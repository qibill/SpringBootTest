package com.qibill.common.json.strategy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;
/**
 * jackson 转化策略
 * 
 * 
 * @author qibill
 */
public class UpperCaseStrategy extends PropertyNamingStrategyBase {

	/**  */
	private static final long serialVersionUID = -3029363382511569345L;

	@Override
	public String translate(String propertyName) {
		return propertyName.toUpperCase();
	}

}
