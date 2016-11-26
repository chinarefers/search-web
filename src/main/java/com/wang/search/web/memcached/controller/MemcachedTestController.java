package com.wang.search.web.memcached.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.core.ServiceResult;
import com.wang.core.cache.memcache.XMemcachedClient;
import com.wang.search.web.base.controller.BaseController;

/**
 * memcached 缓存 test  Controller
 * 
 * @author HeJiawang
 * @date   2016.11.26
 */
@Controller
@RequestMapping(value = "/memcached")
public class MemcachedTestController extends BaseController {
	/**
	 * log
	 */
	private static final Logger logger = LoggerFactory.getLogger(MemcachedTestController.class);
	
	/**
	 * 向memcached中添加数据
	 * @param key 键
	 * @param value 值
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.26
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET})
	@ResponseBody
	public ServiceResult<Void> addCached(String key ,String value){
		ServiceResult<Void> result = new ServiceResult<Void>();
		
		try{
			XMemcachedClient.add(key, value);
		}catch( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的addCached方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
		}
		return result;
	}
}
