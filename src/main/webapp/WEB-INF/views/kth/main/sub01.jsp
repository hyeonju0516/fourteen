<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>탱이 서브01 페이지</h1>
	<table>
		<tr>
			<th>ID : </th>
			<td>
				<input type="text" name="id" placeholder="ID를 입력하세요."/>
			</td>
		</tr>
		<tr>
			<th>NAME : </th>
			<td>
				<input type="text" name="name" placeholder="이름를 입력하세요."/>
			</td>
		</tr>
		<tr>
			<th>EMAIL : </th>
			<td>
				<input type="text" name="email" placeholder="이메일을 입력하세요."/>
			</td>
		</tr>
		<tr>
			<th>PHONE : </th>
			<td>
				<input type="text" name="phone" placeholder="전화번호를 입력하세요."/>
			</td>
		</tr>
		<tr>
			<th>ADDR : </th>
			<td>
				<input type="text" name="addr" placeholder="주소를 입력하세요."/>
			</td>
		</tr>
	</table>
	<button type="button" onclick="add();">추가</button>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		function add(){
			let data = {
					id: $("input[name=id]").val(),
					name: $("input[name=name]").val(),
					email: $("input[name=email]").val(),
					phone: $("input[name=phone]").val(),
					addr: $("input[name=addr]").val(),
			};

			$.ajax({
				type: "post",
				url: "/kth/sub01",
				contentType: "application/json",
				dataType: "json",
				data: JSON.stringify(data),
				success: function(result){
					console.log(result)
				},
				error: function(req, stat, err){
					console.log(err)
				}
			})
		}

	</script>
</body>
</html>