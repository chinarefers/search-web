<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>solr search list</title>
</head>
<body>
	<h1>solr search list</h1>
	<input type="text" id="keyword" name="keyword"/> <input type="button" id="js-solrSearch" value="搜索"/>
	<br/><br/><br/>
	<div>
		<table  width="50%" border="1" cellpadding="2" cellspacing="0" id="context-table">
			<!-- tr><td>ID</td><td>Context</td><td>updateTime</td></tr -->
		</table>
	</div>
	
</body>
<%@include file="resources/doMainUrl.jsp"%>
<script type="text/javascript" src="<%= basePath%>resources/js/jquery-min-1.11.1.js"></script>
<script type="text/javascript" src="<%= basePath%>resources/js/handlebars.min.js"></script>
<script type="text/javascript" src="<%= basePath%>resources/js/search/solrSearchList.js"></script>
<script type="text/javascript">
	search.solr.init();
</script>
</html>