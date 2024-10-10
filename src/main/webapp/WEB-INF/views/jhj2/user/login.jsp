<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<script>
$(function(){
	$('#loginBtn').on('click', function(){
		$.ajax({
			url : '/jhj2/user/login',
			type: 'post',
			data: $("form[name=frm]").serialize(),
			success : function(data) {
				if(data){
					alert("로그인을 성공했습니다.");
					sessionStorage.setItem("loginUser", JSON.stringify(data));
					//console.log(JSON.parse(sessionStorage.getItem("loginUser")));
					location.replace("/jhj2/main");
				}else{
					alert("로그인을 실패했습니다.");
				}
			},
			error: function(e) {
				console.log("회원가입 실패 => ", e)
			}
		});
	});
});
</script>
<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="frm">
			<div>
				<label for="userId">아이디 </label>
				<input type="text" id="userId" name="userId" required />
			</div>
			<div>
				<label for="userPw">비밀번호 </label>
				<input type="password" id="userPw" name="userPw" required />
			</div>
			<button type="button" id="loginBtn">로그인</button>
		</form>
		<ul class="find_wrap">
			<li><a href="#">아이디 찾기</a></li>
			<li><a href="#">비밀번호 찾기</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</main>
</div>
