<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>Home</title>
</head>

<body>

	<h3>유저 넘버 검색 1~5번</h3>
	<form action="/jyOracle/result" method="get">
		<input type="text" name="userNo" placeholder="유저번호 입력하세요." required autoComplete="off" />
		<button type="submit">검색</button>

		<div>${result}</div>
	</form>

</body>
</html>
