package com.wang.search.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.wang.core.util.ApplicationPropertyConfigurer;

/**
 * 获取配置信息工具类
 * 
 * @author HeJiawang
 * @date   2016.11.08
 */
@Component
@Configuration
@PropertySource("classpath:config/application.properties")
public class SystemConfigureUtil {

    @Autowired
    private ApplicationPropertyConfigurer configurer;

    /**
     * 获取检索字段名称
     *
     * @return
     */
    @SuppressWarnings("static-access")
	public String[] searchFields() {
        String property = configurer.getProperty("solr.search.test.fields").toString();
        String[] fields = property.split(",");
        return fields;
    }
}
