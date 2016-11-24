var search = search || {}

/**
 * solr 检索 test
 * @author HeJiwang
 * @date   2016.11.09
 */
search.solr = {
	
	/**
	 * init
	 */
	init	:	function(){
		var _that = this;
		
		_that._bindEvent();
	},
	
	/**
	 * 绑定事件
	 */
	_bindEvent	:	function(){
		var _that = this;
		
		$("#js-solrSearch").on("click", _that.solrSearch);
	},
	
	/**
	 * solr search
	 */
	solrSearch	:	function(){
		var keyword = $("#keyword").val();
		var solrID = null;
		var sort = null;
		
		var param = {
			"keyword"	:	keyword,
			"pIndex"	:	0,	
			"solrID"	:	solrID,	
			"sort"		:	sort	
		};
		
		$.ajax({
			url  : search.domainUrl.baseDomain + "/solr/search",
			data : param,
			type : "get",
			dataType : 'json',
			success:function(result) {
				if(result.success){
					var data = result.result;
					
					$.extend(result, {
						imageUrl : search.domainUrl.imageDomain
					});
					templateHelper("#context-table", "solrSearchList", result, function(){
						
					});
				}
			}
		});
	},
}