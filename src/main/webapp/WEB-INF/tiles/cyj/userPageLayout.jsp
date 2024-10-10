<!DOCTYPE html>
<html>
<%@ page pageEncoding="utf-8"%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
	<meta name="format-detection" content="telephone=no" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="header" />
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- 순서에 유의 -->
	<script src="/js/rsa/rsa.js"></script>
	<script src="/js/rsa/jsbn.js"></script>
	<script src="/js/rsa/prng4.js"></script>
	<script src="/js/rsa/rng.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css' />" />
</head>

<body>
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
</body>
</html>