package com.wang.search.web.solr.service;

import java.util.List;

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
	 * @param keyWord 搜索关键字
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.08
	 */
	ServiceResult<List<SolrTestBean>> searchTest(String keyWord);

}
