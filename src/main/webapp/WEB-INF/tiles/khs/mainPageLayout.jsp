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
</head>

<body>
	<tiles:insertAttribute name="hsMenu" />
	<tiles:insertAttribute name="hsContent" />
	<%-- <tiles:insertAttribute name="body" /> --%>
	<tiles:insertAttribute name="hsFooter" />
</body>
</html>