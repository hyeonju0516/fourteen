<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="frm" id="frm" action="#" method="post">
			<div>
				<label for="userId">아이디 </label>
				<input type="text" id="userId" name="userId" maxlength="20" required />
			</div>
			<div>
				<label for="userPw">비밀번호 </label>
				<input type="password" id="userPw" name="userPw" maxlength="16" required />
			</div>
			<div>
				<label for="otpNumber">OTP </label>
				<input type="text" id="otpNumber" name="otpNumber" maxlength="6" onKeyup="checkedOtp(this);" required />
			</div>
			<button type="button" onclick="login();">로그인</button>
			<button type="button" id="otpInsertBtn">OTP 등록</button>
		</form>
		<ul class="find_wrap">
			<li><a href="#">아이디 찾기</a></li>
			<li><a href="#">비밀번호 찾기</a></li>
			<li><a href="/khs/user/join">회원가입</a></li>
		</ul>
	</main>
</div>
<script>
	function login() {
		lodingBarStart();
		$.ajax({
			url : '/khsLogin/login',
			type: 'post',
			data: $("form[name=frm]").serialize(),
			dataType: 'json',
			success : function(data) {
				lodingBarEnd();
				alert(data.userNm + "님 환영합니다.");
				window.location.href= data.resultUrl;
			},
			error: function(e) {
				lodingBarEnd();
				alert("아이디 또는 패스워드를 확인해주세요.");
			}
		});
	}
	$("#otpInsertBtn").on("click", function(){
		var popWidth = 470, popHeight = 375; //팝업 창 사이즈
		var mtWidth = document.body.clientWidth; //현재 브라우저가 있는 모니터의 화면 폭 사이즈
		var mtHeight = document.body.clientHeight; //현재 브라우저가 있는 모니터의 화면 높이 사이즈
		var scX = window.screenLeft; //현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
		var scY = window.screenTop; //현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

		var popX = scX + (mtWidth - popWidth) / 2 - 50; //팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var popY = scY + (mtHeight - popHeight) / 2 - 50; //팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var url = "<c:url value='/khsOtp/login/googleOtpPop'/>";
		var option = "width=" + popWidth + ", height=" + popHeight + ", left=" + popX + ", top=" + popY + ",scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no";
		var win = window.open(url, "windowPop", option);
		win.focus();
	});
</script>
