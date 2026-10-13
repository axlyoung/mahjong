package com.attic.bj.web.spring.extend;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class CustomizedPropertyConfigurer extends
		PropertySourcesPlaceholderConfigurer {

	private static Map<String, Object> ctxPropertiesMap;

	public CustomizedPropertyConfigurer() {
		// keys like url/username must come from the property file, not OS env vars
		setLocalOverride(true);
	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		super.postProcessBeanFactory(beanFactory);
		// load properties to ctxPropertiesMap
		Properties props;
		try {
			props = mergeProperties();
		} catch (IOException e) {
			throw new BeanInitializationException("Could not load properties", e);
		}
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	// static method for accessing context properties
	public static Object getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
}
