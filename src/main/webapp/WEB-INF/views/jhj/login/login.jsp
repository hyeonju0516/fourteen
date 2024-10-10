<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<script>

$(function(){
	$('#loginBtn').on('click', function(){
		let validate = validationCheck();
		if (validate === false) {
			return false;
		}

		var formData = new FormData($('form')[0]);

		$.ajax({
			url : '/jhj/login/loginProcess',
			type: 'post',
			// data: formData,
			data: $("form[name=loginfrm]").serialize(),
			//contentType: false,
			// processData: false,
			success : function(response) {
				if(response.status === 'authenticated') {
					alert('로그인 성공')
					window.location.href = response.redirect;
				} else {
					alert('로그인 실패:아이디와 비밀번호를 확인하세요')
					window.location.href = response.redirect;
				}
			},
			error: function(e) {
				console.log('Error :: ', e)
			}
		});
	});

	$('#otpBtn').on('click', function() {
		window.location.href = "";
	})



	$("#otpInsertBtn").on("click", function(){
		var popWidth = 470, popHeight = 375; //팝업 창 사이즈
		var mtWidth = document.body.clientWidth; //현재 브라우저가 있는 모니터의 화면 폭 사이즈
		var mtHeight = document.body.clientHeight; //현재 브라우저가 있는 모니터의 화면 높이 사이즈
		var scX = window.screenLeft; //현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
		var scY = window.screenTop; //현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

		var popX = scX + (mtWidth - popWidth) / 2 - 50; //팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var popY = scY + (mtHeight - popHeight) / 2 - 50; //팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var url = "<c:url value='/jhj/login/googleOtpPop.do'/>";
		var option = "width=" + popWidth + ", height=" + popHeight + ", left=" + popX + ", top=" + popY + ",scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no";
		var win = window.open(url, "windowPop", option);
		win.focus();
	 });


	$("#pwResetBtn").on("click", function(){
		var popWidth = 470, popHeight = 375; //팝업 창 사이즈
		var mtWidth = document.body.clientWidth; //현재 브라우저가 있는 모니터의 화면 폭 사이즈
		var mtHeight = document.body.clientHeight; //현재 브라우저가 있는 모니터의 화면 높이 사이즈
		var scX = window.screenLeft; //현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
		var scY = window.screenTop; //현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

		var popX = scX + (mtWidth - popWidth) / 2 - 50; //팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var popY = scY + (mtHeight - popHeight) / 2 - 50; //팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var url = "<c:url value='/jhj/login/pwResetPop.do'/>";
		var option = "width=" + popWidth + ", height=" + popHeight + ", left=" + popX + ", top=" + popY + ",scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no";
		var win = window.open(url, "windowPop", option);
		win.focus();
	 });


	$("#findIdBtn").on("click", function(){
		var popWidth = 470, popHeight = 375; //팝업 창 사이즈
		var mtWidth = document.body.clientWidth; //현재 브라우저가 있는 모니터의 화면 폭 사이즈
		var mtHeight = document.body.clientHeight; //현재 브라우저가 있는 모니터의 화면 높이 사이즈
		var scX = window.screenLeft; //현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
		var scY = window.screenTop; //현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

		var popX = scX + (mtWidth - popWidth) / 2 - 50; //팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var popY = scY + (mtHeight - popHeight) / 2 - 50; //팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
		var url = "<c:url value='/jhj/login/findIdPop.do'/>";
		var option = "width=" + popWidth + ", height=" + popHeight + ", left=" + popX + ", top=" + popY + ",scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no";
		var win = window.open(url, "windowPop", option);
		win.focus();
	 });

});


function validationCheck() {
	let isRight = true;

	// 공백체크(index : 순번, item : 해당 tag 내용)
	$('#loginfrm').find('input').each(function(index, item) {
		if($(this).val() === null || $.trim($(this).val()) === ''|| $(this).val() === 'undefined' || $(this).val().length === 0) {
			alert($(this).attr('data-name') + '를 입력하세요.');
			$(this).focus();
			isRight = false;
		}
	});
	return isRight;
}

</script>
<header>
	<div class="inner">
		<div class="hd-contents">
			<div class="logo">LOGO</div>
			<jsp:include page="/jhj2/menuList" />
			<ul class="sns">
				<li class="sns-list"><a href="#">twitter</a></li>
				<li class="sns-list"><a href="#">twitter</a></li>
			</ul>
			<button class="mb-nav" type="button">
				<span></span>
				<span></span>
				<span></span>
			</button>
		</div>
	</div>
</header>

<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="loginfrm" id="loginfrm">
			<div>
				<label for="userId">아이디 </label>
				<input type="text" id="userId" name="userId" data-name="아이디" required />
			</div>
			<div>
				<label for="userPw">비밀번호 </label>
				<input type="password" id="userPw" name="userPw" data-name="비밀번호" required />
			</div>
			<button type="button" id="loginBtn">로그인</button>
			<button type="button" id="otpInsertBtn">OTP 인증</button>
		</form>
		<ul class="find_wrap">
			<li><a id="findIdBtn">아이디 찾기</a></li>
			<li><a id="pwResetBtn">비밀번호 초기화</a></li>
			<li><a href="/jhj/user/joinPage">회원가입</a></li>
		</ul>
	</main>
</div>
