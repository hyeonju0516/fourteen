<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>결과 출력</title>
</head>
<body>
<div>
 	아이디: <span th:text="${hyOracleVo.id}"></span>
</div>
<div>
 	이름: <span th:text="${hyOracleVo.name}"></span>
</div>
<div>
 	이메일 : <span th:text="${hyOracleVo.email}"></span>
</div>
<div>
 	핸드폰번호 : <span th:text="${hyOracleVo.phone}"></span>
</div>
<div>
 	주소 : <span th:text="${hyOracleVo.addr}"></span>
</div>
</body>
</html>