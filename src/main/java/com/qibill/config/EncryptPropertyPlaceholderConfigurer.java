package com.qibill.config;

import com.qibill.common.utils.DESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.List;

/**
 * 数据库配置解密设置 未启用
 * @author qibill
 * @date 2019/3/22 15:24
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private List<String> encryptPropNames;

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {

		if (encryptPropNames.contains(propertyName)) {
			return DESUtil.decrypt(propertyValue, "qibill");
		}

		return super.convertProperty(propertyName, propertyValue);
	}

	public List<String> getEncryptPropNames() {
		return encryptPropNames;
	}

	public void setEncryptPropNames(List<String> encryptPropNames) {
		this.encryptPropNames = encryptPropNames;
	}
}
