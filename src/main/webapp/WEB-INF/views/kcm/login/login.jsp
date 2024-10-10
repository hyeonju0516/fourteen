<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<style>
.wrap {
	height: 800px;
}

input:read-only {
	background-color: yellow;
}

#certificationCode {
	width: 65%;
}
</style>

<script>
let interval;
$(function(){
	if('${param.MOVE_ERR}' === 'ERRORCONTECT') {
		errorAlert('', '잘못된 접근입니다. 다시 로그인해주세요.');
		top.location='/kcm/login/loginPage';
	}
	if('${param.GBN}' === 'TIMEOUT') {
		top.location='/kcm/login/loginPage';
	}
	if('${param.GBN}' === 'SESSIONOUT') {
		errorAlert('', '세션이 만료되었습니다. 다시 로그인 하여주십시요.');
		top.location='/kcm/login/loginPage';
	}
	if('${param.LOGIN_ERR}' === 'IDNE') {
		errorAlert('', 'ID 또는 비밀번호가 일치하지 않습니다.');
	}
	if('${param.LOGIN_ERR}' === 'IDBL') {
		errorAlert('', '해당 아이디는 계정잠김 상태입니다.');
	}
	if('${param.LOGIN_ERR}' === 'PWNE') {
		errorAlert('', 'ID 또는 비밀번호가 일치하지 않습니다.');
	}
	if('${param.LOGIN_ERR}' === 'OTPE') {
		errorAlert('', 'OTP 인증번호가 맞지 않습니다.');
	}
	if('${param.LOGIN_ERR}' === 'PWNE5') {
		errorAlert('', '5회 이상 로그인 실패하였습니다. 관리자에게 초기화 요청하십시오.');
	}
	if('${param.LOGIN_ERR}' === 'PWCH') {
		errorAlert('', '비밀번호를 재설정 하셔야 합니다.');
	}
	if('${param.LOGIN_ERR}' === 'PWCH90') {
		errorAlert('', '90일 동안 비밀번호를 변경하지 않았습니다. 비밀번호를 갱신 하셔야 합니다.');
	}
	if('${param.LOGIN_ERR}' === '60DATE') {
		errorAlert('', '60일간 사용하지 않아 사용자 계정이 정지되었습니다. \n 시스템 담당자에게 문의해주세요.');
	}
	if('${param.LOGIN_ERR}' === '90DATE') {
		errorAlert('', '90일간 사용하지 않아 사용자 계정이 비활성화되었습니다. \n 시스템 담당자에게 문의해주세요.');
	}

	$('#loginBtn').on('click', function(){

		let isRight = true;

		// 공백체크(index : 순번, item : 해당 tag 내용)
		$('#frm').find('input').each(function(index, item) {
			if($(this).val() === null || $.trim($(this).val()) === ''|| $(this).val() === 'undefined' || $(this).val().length === 0) {
				let id = $(this).attr('id');
				if(id === 'hiddenPw' || id === 'phoneNumber') {
					isRight = true;
				} else {
					$(this).focus();
					errorAlert($(this).attr('data-name'), ' 항목을 입력하세요.');
					isRight = false;
					return false;
				}
			}
		});

		if(!isRight) return false;		// each문 안에서는 return false; 가 안 먹힌다

		$.ajax({
			url : '/kcm/login/otpCodeCheck',
			data : {otpCode : $('#otpCode').val(), userId : $('#userId').val()},
			beforeSend : function() {
				lodingBarStart();
			},
			success : function(result) {
				if(result.resultCode !== 'CM0000') {
					$('#otpCode').focus();
					errorAlert('', result.resultMsg);
				} else {
					// rsa password를 암호화
					let rsa = new RSAKey();
					rsa.setPublic($('#RSAModulus').val(), $('#RSAExponent').val());
					$('#userPw').val(rsa.encrypt($('#userPw').val()));

					let obj = document.frm;
					obj.method = 'post';
					obj.action = '/kcm/login/login';
					obj.submit();
				}
			},
			error: function(xhs, status, error) {
				console.log(error);
			},
			complete : function() {
				lodingBarEnd();
			}
		});
	});

	$('#otpInsertBtn').on('click', function(){
		let popWidth = 470, popHeight = 400;					// 팝업 창 사이즈
		let mtWidth = document.body.clientWidth;				// 현재 브라우저가 있는 모니터의 화면 폭 사이즈
		let mtHeight = document.body.clientHeight;				// 현재 브라우저가 있는 모니터의 화면 높이 사이즈
		let scX = window.screenLeft;							// 현재 브라우저의 x 좌표(모니터 두 대를 합한 총 위치 기준)
		let scY = window.screenTop;								// 현재 브라우저의 y 좌표(모니터 두 대를 합한 총 위치 기준)

		let popX = scX + (mtWidth - popWidth) / 2 - 50;			// 팝업 창을 띄울 x 위치 지정(모니터 두 대를 합한 총 위치 기준)
		let popY = scY + (mtHeight - popHeight) / 2 - 50;		// 팝업 창을 띄울 y 위치 지정(모니터 두 대를 합한 총 위치 기준)
		let url = '/kcm/login/googleOtpPop';
		let option = 'width=' + popWidth + ', height=' + popHeight + ', left=' + popX + ', top=' + popY + ',scrollbars=yes, resizeable=no, menubar=no, status=no, toolbar=no';
		let win = window.open(url, 'windowPop', option);
		win.focus();
	});

	$('#phoneInsertBtn').on('click', function(){
		if($('#phoneNumber').val() === null || $('#phoneNumber').val() === ''|| $('#phoneNumber').val() === 'undefined' || $('#phoneNumber').val().length === 0) {
			$('#phoneNumber').focus();
			errorAlert('', '전화번호를 입력하세요');
			return false;
		}

		let phoneChecked = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
		let phoneLength = $('#phoneNumber').val();
		if(phoneLength.length < 10) {
			$('#phoneNumber').focus();
			errorAlert('', '정확한 전화번호를 입력하세요');
			return false;
		}
		if(!phoneChecked.test($('#phoneNumber').val())) {
			$('#phoneNumber').focus();
			errorAlert('', '잘못된 휴대폰 번호입니다.');
			return false;
		}

		$('.certificationCodeDiv').html('');
		$('#phoneCheckedBtn').remove();

		let phoneNumber = $('#phoneNumber').val();
		phoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7, 11);

		$.ajax({
			type : "post",
			url:"/kcm/login/send/phoneSend?phoneNumber=" + phoneNumber,
			beforeSend : function() {
				lodingBarStart();
			},
			success : function(result) {
				if(result.resultCode === 'MD0008') {
					$('#phoneNumber').attr('readonly', true);
					$('.certificationCodeDiv').append(
							'<label for="certificationCode" class="certificationCode">인증번호</label>'
							+ '<input type="text" id="certificationCode" name="certificationCode" maxlength="6" data-name="인증번호" onKeyup="checkedNumber(this);" />'
							+ '<span id="timerArea" style="font-weight:bold;color:red;margin-left: 10px;"></span>'
					);
					$('#frm').append('<button style="background:#27b78f;" type="button" id="phoneCheckedBtn">인증 확인</button>');
					$('.wrap').css('height', '900px');
					showTimer();
				} else {
					errorAlert('', result.resultMsg);
				}
			},
			error: function(xhs, status, error) {
				console.log(error);
			},
			complete : function() {
				lodingBarEnd();
			}
		});
	});

	$(document).on('click', '#phoneCheckedBtn', function(){
		if($('#certificationCode').val() === null || $('#certificationCode').val() === ''|| $('#certificationCode').val() === 'undefined' || $('#certificationCode').val().length === 0) {
			$('#certificationCode').focus();
			errorAlert('', '인증번호를 입력하세요');
			return false;
		}

		if($('#phoneNumber').val() === null || $('#phoneNumber').val() === ''|| $('#phoneNumber').val() === 'undefined' || $('#phoneNumber').val().length === 0) {
			errorAlert('', '잘못된 접근 입니다.');
			return false;
		}

		// 인증코드 일치 여부
		let phoneNumber = $('#phoneNumber').val();
		phoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7, 11);
		$.ajax({
			url : '/kcm/login/send/certificationCodeCheck',
			type : "post",
			data : {certificationCode : $("#certificationCode").val(), phoneNumber : phoneNumber},
				beforeSend : function() {
				lodingBarStart();
			},
			success : function(result) {
				if(result.resultCode === 'MD0009') {
					successAlert('', result.resultMsg)
				} else {
					errorAlert('', result.resultMsg)
				}
			},
			error: function(xhs, status, error) {
				console.log(error);
			},
			complete : function() {
				lodingBarEnd();
			}
		});
	});
});
</script>

<div class="wrap">
	<main>
		<h2>로그인</h2>
		<form name="frm" id="frm">
			<!-- RSA -->
			<input type="hidden" id="RSAModulus" value="${RSAModulus }" />
			<input type="hidden" id="RSAExponent" value="${RSAExponent }" />
			<div>
				<label for="userId">아이디 </label>
				<input type="text" id="userId" name="userId" maxlength="20" data-name="아이디" required />
			</div>
			<div>
				<label for="userPw">비밀번호 </label>
				<input type="password" id="userPw" name="userPw" maxlength="16" data-name="비밀번호" autocomplete="off" required />
			</div>
			<div>
				<label for="otpCode">OTP</label>
				<input type="text" id="otpCode" name="otpCode" maxlength="6" data-name="otp코드" onKeyup="checkedNumber(this);" required />
			</div>
			<div>
				<label for="phoneNumber">전화번호</label>
				<input type="text" id="phoneNumber" name="phoneNumber" maxlength="20" data-name="전화번호" onKeyup="checkedNumber(this);" required />
			</div>
			<div class="certificationCodeDiv"></div>
			<button type="button" id="loginBtn">로그인</button>
			<button type="button" id="otpInsertBtn">OTP 등록</button>
			<button type="button" id="phoneInsertBtn">인증번호 요청</button>
		</form>
		<ul class="find_wrap">
			<li><a href="/kcm/login/findUserId">아이디 찾기</a></li>
			<li><a href="/kcm/login/findUserPw">비밀번호 초기화</a></li>
			<li><a href="/kcm/user/join">회원가입</a></li>
		</ul>
	</main>
</div>
