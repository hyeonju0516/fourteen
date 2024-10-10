<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="infoData" method="POST" action="/kth/main/prac03/addInfo">
		<table>
			<tr>
				<td><span>id :</span></td>
				<td><input name="id" class="id" id="id" /></td>
			</tr>
			<tr>
				<td><span>name :</span></td>
				<td><input name="name" class="name" id="name" /></td>
			</tr>
			<tr>
				<td><span>email :</span></td>
				<td><input name="email" class="email" id="email" /></td>
			</tr>
			<tr>
				<td><span>phone :</span></td>
				<td><input name="phone" class="phone" id="phone" /></td>
			</tr>
			<tr>
				<td><span>addr :</span></td>
				<td><input name="addr" class="addr" id="addr" /></td>
			</tr>
		</table>
		<button type="button" onclick="add();">ADD</button>
	</form>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		function add() {
			$.ajax({
				type: 'POST',
				url: '/kth/main/prac03/addInfo',
				data: $('#infoData').serialize(),
				success: function(res) {
					console.log('result : ', res);
				},
				error: function(xhr, stat, error) {
					console.log('error : ', error);
				}

			})
		}
	</script>
</body>
</html>