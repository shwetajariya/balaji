package com.sur.sms.gateway.sms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {

	private static Map propertiesMap;
	private int totalModem;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);
		System.out.println("file entry = " + props.propertyNames());

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			System.out.println(" key= " + keyStr);
			propertiesMap.put(
					keyStr,
					parseStringValue(props.getProperty(keyStr), props,
							new HashSet()));
		}
		System.out.println(" end for loop= ");
	}

	public static String getProperty(String name) {
		return (String) propertiesMap.get(name);
	}
}