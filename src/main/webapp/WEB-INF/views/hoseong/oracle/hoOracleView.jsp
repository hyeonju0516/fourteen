<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
	<title>View Page</title>
</head>

<body>
	<%@ include file="/WEB-INF/fragment/hoseong/header.jsp" %>
	<%@ include file="/WEB-INF/fragment/hoseong/menubar.jsp" %>
	<div class="content">
		<h2>USER View</h2>
		<table>
			<thead>
				<tr>
					<th colspan="2">USER View !!</th>
					<input type="hidden" name="userNo" value="${info.userNo}" />
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>ID : </th>
					<td>${info.id}</td>
				</tr>
				<tr>
					<th>Name : </th>
					<td>${info.name}</td>
				</tr>
				<tr>
					<th>Phone : </th>
					<td>${info.phone}</td>
				</tr>
				<tr>
					<th>주소 : </th>
					<td>${info.addr}</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td>${info.email}</td>
				</tr>
			</tbody>
		</table>
		<input type="button" onclick="location.href='/hoseong/update/${info.userNo}'" value="수정" />
		<input type="button" onclick="deleteUser()" value="삭제" />
		<input type="button" onclick="location.href='/hoseong/list'" value="리스트" />
		<input type="button" onclick="history.back()" value="뒤로가기" />
	</div>
	<%@ include file="/WEB-INF/fragment/hoseong/footer.jsp" %>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

		function deleteUser() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				let data = {
						userNo: $('[name=userNo]').val(),
					};
				$.ajax({
					url: '/hoseong/delete',
					type: 'POST',
					data: JSON.stringify(data),
					contentType: 'application/json',
					processData: false,
					success: function(response) {
						window.location.href="/hoseong/list"
					},
					error: function(xhr, status, error) {
						alert(error);
					}
				});
			}
		};

	</script>
</body>
</html>