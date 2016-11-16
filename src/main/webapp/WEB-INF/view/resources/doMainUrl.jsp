<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="com.wang.core.util.DomainUrlUtil"%>
<script type="text/javascript">
	var search = search || {};
	search.domainUrl = {
		baseDomain : '<%=DomainUrlUtil.BASEURL_DOMAIN%>',
		imageDomain : '<%=DomainUrlUtil.IMG_BASEURL_DOMAIN%>',
		tplDomain : '<%=DomainUrlUtil.TPL_DOMAIN%>',
	}
</script>
