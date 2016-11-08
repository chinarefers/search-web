package com.wang.search.web.solr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.core.ServiceResult;
import com.wang.search.web.base.controller.BaseController;
import com.wang.search.web.solr.bean.SolrTestBean;
import com.wang.search.web.solr.service.SolrTestService;

/**
 * solr 搜索  Controller
 * 
 * @author HeJiawang
 * @date   2016.11.08
 */
@Controller
@RequestMapping(value = "/solr")
public class SolrTestController  extends BaseController  {
	
	/**
	 * log
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolrTestController.class);
	
	/**
	 * solrTestService
	 */
	@Autowired
	private SolrTestService solrTestService;
	
	/**
	 * solr 搜索
	 * @param keyWord 搜索关键字
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.08
	 */
	@RequestMapping(value = "search", method = {RequestMethod.GET})
	public ServiceResult<List<SolrTestBean>> searchTest(@RequestParam(value = "keyword", defaultValue = "*") String keyWord){
		ServiceResult<List<SolrTestBean>> result = null;
		try{
			
			result = solrTestService.searchTest(keyWord);
		} catch( Exception e ) {
			logger.error("异常发生在"+this.getClass().getName()+"类的searchTest方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
		}
		return result;
	}
}
