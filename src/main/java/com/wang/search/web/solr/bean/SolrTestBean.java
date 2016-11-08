package com.wang.search.web.solr.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class SolrTestBean {

	@Field("solrID")
	private String solrID;
	
	@Field("context")
	private String context;
	
	@Field("updateTime")
	private Date updateTime;

	public String getSolrID() {
		return solrID;
	}

	public void setSolrID(String solrID) {
		this.solrID = solrID;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
