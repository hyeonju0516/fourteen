<!DOCTYPE html>
<html>
<%@ page pageEncoding="utf-8"%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
	<meta name="format-detection" content="telephone=no" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="Header" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/history.css' />" />
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>
	<%-- <tiles:insertAttribute name="seMenu" /> --%>
	<tiles:insertAttribute name="seContent" />
	<tiles:insertAttribute name="Footer" />
</body>
</html>/>