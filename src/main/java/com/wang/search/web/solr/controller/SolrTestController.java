package com.wang.search.web.solr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * @param pInteger 分页——起始条数
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.08
	 */
	@RequestMapping(value = "/search", method = {RequestMethod.GET})
	@ResponseBody
	public ServiceResult<List<SolrTestBean>> searchTest(HttpServletRequest request,
			@RequestParam(value = "keyword", defaultValue = "*") String keyWord,
			@RequestParam(value = "pIndex", defaultValue = "0") Integer pIndex){
		ServiceResult<List<SolrTestBean>> result = null;
		try{
			/**
			 * 解析其他solr搜索条件
			 */
			Map<String, String> condition = this.parseCondition(request);
			
			result = solrTestService.searchTest(keyWord, pIndex, condition);
		} catch( Exception e ) {
			logger.error("异常发生在"+this.getClass().getName()+"类的searchTest方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
		}
		return result;
	}
	
	/**
	 * 解析其他solr搜索条件
	 * @param request 获取请求参数
	 * @return 搜索条件
	 */
	private Map<String, String> parseCondition( HttpServletRequest request ){
		Map<String, String> condition = new HashMap<String, String>();
		
		String solrID = request.getParameter("solrID");
		if (StringUtils.isNotBlank(solrID)) {
			condition.put("solrID", solrID);
		}
		
		String sort = request.getParameter("sort");
		if (StringUtils.isNotBlank(sort)) {
			condition.put("sort", sort);
		}
		
		return condition;
	}
}
