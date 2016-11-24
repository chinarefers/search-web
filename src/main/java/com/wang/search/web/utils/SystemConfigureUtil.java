package com.wang.search.web.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
	
	/**
	 * 排序顺序——desc
	 * @return
	 */
	public String getSortDESC(){
    	String str = configurer.getProperty("solr.search.test.sort.desc").toString();
    	return str;
    }
	
	/**
	 * 排序顺序——asc
	 * @return
	 */
	public String getSortASC(){
    	String str = configurer.getProperty("solr.search.test.sort.asc").toString();
    	return str;
    }
	
	/**
	 * 获取进行排序的字段
	 * @return
	 */
	public Map<Integer, String> getSort() {
        String sortFields = configurer.getProperty("solr.search.test.sort").toString();
        List<String> fields = Arrays.asList(StringUtils.split(sortFields, ";"));
        Map<Integer, String> result = new HashMap<Integer, String>(fields.size());
        for (String field : fields) {
            String[] s = StringUtils.split(field, ":");
            result.put(Integer.parseInt(s[0].trim()), s[1].trim());
        }
        return result;
    }
	
    /**
     * 获取查询条件对应字段
     * @return
     */
    public Map<String, String> getCondition() {
        String prop = configurer.getProperty("solr.search.test.condition").toString();
        String[] fields = prop.split(";");
        Map<String, String> result = new HashMap<String, String>();
        for (String field : fields) {
            String[] s = field.split(":");
            result.put(s[0], s[1]);
        }
        return result;
    }
}
