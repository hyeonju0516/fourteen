<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>Home</title>
	<style>
		form{
			width:300px;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			margin: 1rem auto;
		}
		h3{
			width:300px;
			text-align:center;
			margin: 0 auto;
			margin-top: 25vh;
		}

		input{
			width: 250px;
			height:40px;
		}

		button{
			width:250px;
			height:30px
		}
	</style>
</head>

<body>

	<h3>데이터</h3>
	<form action="/jyOracle/addInfo" method="post">
		<label>
			<input id="id" name="id" type="text" placeholder="id" required autoComplete="off" />
		</label>
		<br/>
		<label>
			<input id="name" name="name" type="text" placeholder="닉네임" required autoComplete="off" />
			<!-- input의 name값과 Vo의 변수명이 일치해야 바인딩(연결) 됨. 뀨.뀨-->
		</label>
		<br/>
		<label>
			<input id="phone" name="phone" type="text" placeholder="010" required autoComplete="off" />
		</label>
		<br/>
		<button type="submit">전송</button>
	</form>

</body>
</html>
