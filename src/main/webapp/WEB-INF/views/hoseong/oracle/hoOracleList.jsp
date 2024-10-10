<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
	<title>List Page</title>
</head>

<body>
	<%@ include file="/WEB-INF/fragment/hoseong/header.jsp" %>
	<%@ include file="/WEB-INF/fragment/hoseong/menubar.jsp" %>
	<div class="content">
		<h2>USER ListTable</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty list}">
					<c:forEach var="item" items="${list}">
						<tr>
							<td><a href="/hoseong/view/${item.userNo}">${item.id}</a></td>
							<td>${item.name}</td>
							<td>${item.phone}</td>
							<td>${item.addr}</td>
							<td>${item.email}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6">List is empty</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<input type="button" onclick="location.href='/hoseong/add'" value="추가" />
		<input type="button" onclick="history.back()" value="뒤로가기" />
	</div>
	<%@ include file="/WEB-INF/fragment/hoseong/footer.jsp" %>
</body>
</html>