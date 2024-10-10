<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/login.css' />" />

<script>
	$(function() {
		$('#loginBtn').on('click', function() {
			let validate = validationCheck();
			if (validate === false) {
				return false;
			}

			$.ajax({
				url : '/jy/userLogin/post',
				type : 'post',
				data : $("form[name=loginFrm]").serialize(),
				success : function(data) {
					if (data.userId) {
						alert('로그인 성공');
						window.location.href = '/jy/home';
					} else {
						alert('로그인 실패');
					}
				},
				error : function(e) {
					console.log('>>>>>>> :: 에러', e)
				}
			})
		})
	});

	function validationCheck() {
		let isRight = true;
		let regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // email 유효성검사
		let regHan = /^[가-힣]{2,15}$/; // 한글 유효성검사(2자리 이상 15자리 이하)
		let regId = /^(?!.*([a-zA-Z0-9])\1{4})[a-zA-Z0-9]{4,20}$/; // 4~20자 이내의 영문,숫자 아이디 (특문 X) , 공백 안됨 , 동일한 5자 이상 안됨
		let regpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/; // 비밀번호 영문자+숫자+특수조합(8~16자리 입력) 정규식
		// let phoneChecked = /^[0-9-]{1,16}$/;
		let regPhone = /^(01[016789]{1})[0-9]{3,4}[0-9]{4}$/; // 숫자만 입력하는 정규식

		$('#loginFrm').find('input').each(
				function(idx, item) {
					if ($(this).val() === null || $.trim($(this).val()) === ''
							|| $(this).val() === 'undefined'
							|| $(this).val().length === 0) {
						alert($(this).attr('data-name') + '항목을 입력하세요.');
					}
				})

		if (!isRight) {
			return false;
		}

		if (!regId.test($('#userId').val())) {
			alert('잘못된 아이디 형식입니다. (4~20자 이내 영문, 숫자를 사용한 아이디)');
			$('#userId').focus();
			return false;
		}

		if (!regpw.test($('#userPw').val())) {
			alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~16자리 사용해야 합니다.');
			$('#userPw').focus();
			return false;
		}

		return isRight;
	}
</script>

<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="loginFrm" id="loginFrm">
			<div>
				<label for="userId">아이디 </label> <input type="text" id="userId"
					name="userId" data-name="아이디" required />
			</div>
			<div>
				<label for="userPw">비밀번호 </label> <input type="password" id="userPw"
					name="userPw" data-name="비밀번호" required />
			</div>
			<button id="loginBtn" type="button">로그인</button>
		</form>
		<ul class="find_wrap">
			<li><a href="#">아이디 찾기</a></li>
			<li><a href="#">비밀번호 찾기</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</main>

</div>