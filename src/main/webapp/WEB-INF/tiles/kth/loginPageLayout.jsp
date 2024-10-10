<!DOCTYPE html>
<html>
<%@ page pageEncoding="utf-8"%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
	<meta name="format-detection" content="telephone=no" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="kthHeader" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css' />" />
	<%-- <%@ include file="/WEB-INF/include/include-header.jsp"%> --%>
</head>

<body>
	<%-- <tiles:insertAttribute name="kthMenu" /> --%>
	<tiles:insertAttribute name="kthContent" />
	<tiles:insertAttribute name="kthFooter" />
</body>
</html>