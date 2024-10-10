<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>ADDR</th>
			</tr>
		</thead>
		<c:forEach var="item" items="${list }">
			<tbody>
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.email }</td>
					<td>${item.phone }</td>
					<td>${item.addr }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>