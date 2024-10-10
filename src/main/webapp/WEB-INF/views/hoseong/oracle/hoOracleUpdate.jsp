<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
	<title>Update Page</title>
</head>

<body>
	<%@ include file="/WEB-INF/fragment/hoseong/header.jsp" %>
	<%@ include file="/WEB-INF/fragment/hoseong/menubar.jsp" %>
	<div class="content">
		<h2>USER Update</h2>
		<table>
			<thead>
				<input type="hidden" name="userNo" value="${info.userNo}" />
				<tr>
					<th colspan="2">USER Update !!</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>ID : </th>
					<td><input type="text" name="id" value="${info.id}" readonly /></td>
				</tr>
				<tr>
					<th>Name : </th>
					<td><input type="text" name="name" value="${info.name}" /></td>
				</tr>
				<tr>
					<th>Phone : </th>
					<td><input type="text" name="phone" value="${info.phone}" /></td>
				</tr>
				<tr>
					<th>주소 : </th>
					<td><input type="text" name="addr" value="${info.addr}" /></td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td><input type="text" name="email" value="${info.email}" /></td>
				</tr>
			</tbody>
		</table>
		<input type="button" onclick="update()" value="저장" />
		<input type="button" onclick="location.href='/hoseong/list'" value="리스트" />
		<input type="button" onclick="history.back()" value="뒤로가기" />
	</div>
	<%@ include file="/WEB-INF/fragment/hoseong/footer.jsp" %>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

		function update() {
			let userNo = $('[name=userNo]').val();
			let data = {
					userNo: userNo,
					name: $('[name=name]').val(),
					phone: $('[name=phone]').val(),
					addr: $('[name=addr]').val(),
					email: $('[name=email]').val()
				};

			$.ajax({
				url: '/hoseong/update',
				type: 'POST',
				data: JSON.stringify(data),
				contentType: 'application/json',
				processData: false,
				success: function(response) {
					window.location.href="/hoseong/view/" + userNo
				},
				error: function(xhr, status, error) {
					console.error('error :: ', error);
				}
			});
		};

	</script>
</body>
</html>