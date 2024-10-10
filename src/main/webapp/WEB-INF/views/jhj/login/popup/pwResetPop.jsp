<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 초기화</title>
<link rel="stylesheet" href="path/to/your/css/file.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="<c:url value='/common/qrcode.js' />"></script>
</head>

<script>
$(document).ready(function() {
    $('#pwResetBtn').on('click', function() {
		let validate = validationCheck();
		if (validate === false) {
			return false;
		}

		$.ajax({
		url: '/jhj/login/pwResetProcess',
		type: 'post',
		data: $("form[name=resetfrm]").serialize(),
		success: function(response) {
			if (response.result) {
			alert('비밀번호 재설정을 완료했습니다.');
			window.opener.location.reload(); // 메인 창을 리로드
			window.close(); // 팝업 창을 닫기
		} else {
			alert('입력한 아이디 혹은 이메일이 정확한지 확인하세요');
			}
		},
		error: function(e) {
			console.log('Error :: ', e);
			alert('비밀번호 재설정 요청 중 오류가 발생했습니다.');
			window.close()
		}
		});
	});

	$('#email').on('change', function(){
		let optionVal = $('[id=email] :selected').val();		// :selected 앞에 한칸 띄워줘야됨(선택된 값 가져오기)
		if(optionVal !== '') $('#userDomail').val(optionVal).attr('readonly', true);
		else $('#userDomail').val('').focus().attr('readonly', false);
	});
});

function validationCheck() {
	let isRight = true;
	let regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;	// email 유효성검사																					// 한글 유효성검사(2자리 이상 15자리 이하)
	let regId = /^(?!.*([a-zA-Z0-9])\1{4})[a-zA-Z0-9]{4,20}$/;																// 4~20자 이내의 영문,숫자 아이디 (특문 X) , 공백 안됨 , 동일한 5자 이상 안됨
	let regpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;														// 비밀번호 영문자+숫자+특수조합(8~16자리 입력) 정규식
	// let phoneChecked = /^[0-9-]{1,16}$/;
	let regPhone = /^(01[016789]{1})[0-9]{3,4}[0-9]{4}$/;																	// 숫자만 입력하는 정규식

	// 공백체크(index : 순번, item : 해당 tag 내용)
	$('#frm').find('input').each(function(index, item) {
		if($(this).val() === null || $.trim($(this).val()) === ''|| $(this).val() === 'undefined' || $(this).val().length === 0) {
			if($(this).attr('id') === 'userDomail' && $('[id=email] :selected').val() !== '') {
				isRight = true;
			} else {
				alert($(this).attr('data-name') + ' 항목을 입력하세요.');
				$(this).focus();
				isRight = false;
				// return false;
			}
		}
	});

	if(!isRight) return false;		// each문 안에서는 return false; 가 안 먹힌다

	if(!regId.test($('#userId').val())) {
		alert('잘못된 아이디 형식입니다. (4~20자 이내 영문, 숫자를 사용한 아이디)');
		$('#userId').val('');
		$('#userId').focus();
		return false;
	}

	if(!regpw.test($('#userPw').val())) {
		alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~16자리 사용해야 합니다.');
		$('#userPw').val('');
		$('#userPw').focus();
		return false;
	}

	if(!regEmail.test($("#userEmail").val() + '@' + $("#userDomail").val())) {
		alert("잘못된 Email 형식입니다.");
		$('#userDomail').val('');
		$('#userDomail').focus();
		return false;
	}

	return isRight;
}

</script>


<body>
	<div class="otpDiv">
	<h4>&nbsp;&nbsp;&nbsp;비밀번호 초기화</h4>
		<form name="resetfrm" id="resetfrm">
			<div>
				<label for="userId">아이디 <span>*</span></label>
				<div>
				<input type="text" id="userId" name="userId" placeholder="ID 입력" data-name="아이디" maxlength="20" onKeyup="checkedId(this);" />
				</div>
			</div>
			<div>
				<label for="userPw">비밀번호 <span>*</span></label>
				<input type="password" id="userPw" name="userPw" placeholder="비밀번호 입력" data-name="비밀번호" maxlength="16" autoComplete="off" />
			</div>
			<div>
				<label for="userEmail">이메일 <span>*</span></label>
				<div>
					<input type="text" id="userEmail" name="userEmail" placeholder="이메일 입력" data-name="이메일" maxlength="15" />
					<span>@</span>
					<input type="text" id="userDomail" name="userDomail" placeholder="직접 입력" data-name="도메인" maxlength="15" />
					<select id="email">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="kakao.com">kakao.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>
					</select>
				</div>
			</div>
			<button class="btn btn-success btnType1 a2" type="button" id="pwResetBtn">비밀번호 초기화</button>
		</form>
	</div>
</body>
</html>
