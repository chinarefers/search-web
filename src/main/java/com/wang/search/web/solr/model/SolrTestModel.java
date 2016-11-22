package com.wang.search.web.solr.model;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.PagerInfo;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.search.web.solr.bean.SolrTestBean;

/**
 * solr 搜索  model
 * 
 * @author HeJiawang
 * @date   2016.11.08
 */
@Service
public class SolrTestModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(SolrTestModel.class);
	
	/**
	 * solrClient
	 */
	@Autowired
    private SolrClient solrClient;
	
	/**
	 * solr 搜索
	 * @param keyWord 搜索关键字
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.08
	 */
	public ServiceResult<List<SolrTestBean>> searchTest(SolrQuery solrQuery) throws Exception {
		Assert.notNull(solrClient, "Property 'solrClient' is required.");
		if( solrQuery == null ) throw new BusinessException("solrQuery不能为空");
		logger.debug("solr查询请求:\t{}", solrQuery.toString());
		
		ServiceResult<List<SolrTestBean>> result = new ServiceResult<>();
		
		QueryResponse response = solrClient.query(solrQuery);
		List<SolrTestBean> beanList = response.getBeans(SolrTestBean.class);	//查询数据
		Long totalCount = response.getResults().getNumFound();	//总条数

		PagerInfo pageInfo = new PagerInfo();
		pageInfo.setRowsCount(totalCount.intValue());
		
		result.setResult(beanList);
		result.setPager(pageInfo);
		
		solrQuery.clear();
		return result;
	}

}
