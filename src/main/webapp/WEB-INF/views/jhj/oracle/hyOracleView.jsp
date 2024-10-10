<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Hello hyhy</title>
</head>
<body>
<form name = "inputForm" method = "post" action = "/hyOracleInput">
	ID : <input type="text" name="id"/><br>
	NAME : <input type="text" name="name"/><br>
	EMAIL : <input type="text" name="email"/><br>
	PHONE : <input type="text" name="phone"/><br>
	ADDR : <input type="text" name="addr"/><br>
<button type="submit">제출</button>
</form>
</body>
</html>