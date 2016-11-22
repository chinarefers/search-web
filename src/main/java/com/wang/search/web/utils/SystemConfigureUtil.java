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
@SuppressWarnings("static-access")
public class SystemConfigureUtil {

    @Autowired
    private ApplicationPropertyConfigurer configurer;

    /**
     * 获取检索字段名称
     *
     * @return
     */
	public String[] searchFields() {
        String property = configurer.getProperty("solr.search.test.fields").toString();
        String[] fields = property.split(",");
        return fields;
    }
    
    /**
     * 获取solr查询后，每页显示多少条
     * @return
     */
    public Integer getSolrRow(){
    	String rowStr = configurer.getProperty("solr.search.test.row").toString();
    	return Integer.getInteger(rowStr);
    }
    
    /**
     * solr查询时是否设置分类检索(分片)
     * @return
     */
    public Boolean isFacet(){
    	String isFacet = configurer.getProperty("solr.search.test.isFacet").toString();
    	return Boolean.parseBoolean(isFacet);
    }
    
    /**
     * 获取solr查询时，分类检索的词
     * @return
     */
    public String getFacetStr(){
    	String facetStr = configurer.getProperty("solr.search.test.facetStr").toString();
    	return facetStr;
    }

    /**
     * 获取过滤结果，即能够查询出那些字段
     * @return
     */
	public String[] getFilterFields() {
		String fieldsStr = configurer.getProperty("solr.search.test.filterFields").toString();
		String[] fields = fieldsStr.split(",");
		return fields;
	}
}
