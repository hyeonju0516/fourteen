<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		input[type:text]{
			display: inline-block;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" placeholder="id"/></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name="password" placeholder="pw"/></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="name" placeholder="name"/></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input type="text" name="phone" placeholder="phone"/></td>
		</tr>
		<tr>
			<td>ADDRESS</td>
			<td><input type="text" name="addr" placeholder="addr"/></td>
		</tr>
	</table>

	<button type="button" onclick="add()">ADD</button>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">

		function(){
			let data = {
					id: $('[name=id]').val(),
					pw: $('[name=pw]').val(),
					name: $('[name=name]').val(),
					phone: $('[name=phone]').val(),
					address: $('[name=address]').val(),
				};

				$.ajax({
					type: "post",
					url: "/kth/add",
					data: JSON.stringify(data),
					content-tpye: application/json,
					success: function(result){
						console.log(result)
					},
					error: function(req, status, error){
						console.log(error);
					}
				}
			);
		}
	</script>
</body>
</html>