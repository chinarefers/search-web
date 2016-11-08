<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>solr search list</title>
</head>
<body>
	
	<h1>solr search list</h1>
	<input type="text" id="context" name="context"/> <input type="button" id="js-solrSearch" value="搜索"/>
	<br/><br/><br/>
	<div>
		<table  width="50%" border="1" cellpadding="2" cellspacing="0" id="context-table">
			<tr><td>ID</td><td>Context</td><td>updateTime</td></tr>
		</table>
	</div>
	
</body>
</html>