package com.wang.search.web.solr.service;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.search.web.solr.bean.SolrTestBean;

/**
 * solr 搜索  service
 * 
 * @author HeJiawang
 * @date   2016.11.08
 */
public interface SolrTestService {

	/**
	 * solr 搜索
	 * 
	 * @param keyWord 搜索关键字
	 * @param pIndex 分页
	 * @param condition 其他搜索条件
	 * 
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.08
	 */
	ServiceResult<List<SolrTestBean>> searchTest(String keyWord, Integer pIndex, Map<String, String> condition);

}
