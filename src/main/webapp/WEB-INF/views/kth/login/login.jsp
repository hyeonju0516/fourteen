<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<script>
    $(function() {
        $('#loginBtn').on('click', function() {
            $.ajax({
                url: '/kth/login/loginCheck',
                type: 'POST',
                data: $('form').serialize(),
                success: function(result) {
                    console.log(result);
                    if(result.userId != null) {
                        alert('로그인 성공' + result);
                        window.location.href = '/kth/main/main';
                    }else alert('로그인 실패ㅇㅇㅇ');
                },
                error: function(xhr, status, error) {
                    console.log(error);
                    alert('로그인 실패sss');
                }
            });
        });
        $('#otpInsertBtn').on('click', function(){
            let popWidth = 470, popHeight = 375; 		//팝업 창 사이즈
            let mtWidth = document.body.clientWidth; 	//현재 브라우저가 있는 모니터의 화면 폭 사이즈
            let mtHeight = document.body.clientHeight; 	//현재 브라우저가 있는 모니터의 화면 높이 사이즈
            let scX = window.screenLeft; 				//현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
            let scY = window.screenTop; 				//현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

            let popX = scX + (mtWidth - popWidth) / 2 - 50; //팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
            let popY = scY + (mtHeight - popHeight) / 2 - 50; //팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
            let url = '/cyj/googleOtpPop';
            let option = 'width=' + popWidth + ', height=' + popHeight + ', left=' + popX + ', top=' + popY + ',scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no';
            let win = window.open(url, "windowPop", option);
            win.focus();
        });
    });
</script>

<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="login" id="login">
			<div>
				<label for="userId">아이디</label>
				<input type="text" id="userId" name="userId" required />
			</div>
			<div>
				<label for="userPw">비밀번호</label>
				<input type="password" id="userPw" name="userPw" required />
			</div>
			<div>
                <label for="userOtp">OTP</label>
                <input type="text" id="userOtp" name="userOtp" required />
            </div>
			<button type="button" id="otpInsertBtn">OTP 발급</button>
			<button type="button" id="loginBtn">로그인</button>
		</form>
		<ul class="find_wrap">
			<li><a href="javascript:void(0);">아이디 찾기</a></li>
			<li><a href="javascript:void(0);">비밀번호 찾기</a></li>
			<li><a href="javascript:void(0);">회원가입</a></li>
		</ul>
	</main>
</div>
