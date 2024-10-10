<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css' />" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
.userZipCode {
	width: 23% !important;
}
.userZipCode, .userAddr {
	margin-bottom: 10px;
}
</style>

<script>
let idCheck = false

$(function(){
	$('#joinBtn').on('click', function(){
		let validate = validationCheck();						// 발리 데이션 체크
		if(validate === false) return false;
		if(!idCheck) {
			alert('아이디 중복확인을 해주세요')
			return false;
		}
		if(!doubleCheckId(true)) return false;

		//rsa암호화
		//rsa에 RSAModulus,RSAExponent값을 넣고 hiddenPw에는 공백을 넣어서 넘긴다.
		/* var rsa = new RSAKey();
		rsa.setPublic($('#RSAModulus').val(),$('#RSAExponent').val());
		$("#hiddenPw").val(rsa.encrypt($('#userPw').val()));
		$("#userPw").val(''); */

		var formData = new FormData($('form')[0]);

		$.ajax({
			url : '/jhj2/user/join',
			type: 'post',
			// data: formData,
			data: $("form[name=frm]").serialize(),
			//contentType: false,
			// processData: false,
			success : function(data) {
				if(data){
					alert("회원가입을 완료되었습니다.");
					location.replace("/jhj2/user/login");
				}else{
					alert("회원가입에 실패했습니다.");
				}
			},
			error: function(e) {
				console.log("회원가입 실패 => ", e)
			}
		});
		/* let obj = document.frm;
		obj.action = '/cyj/user/userJoin';
		obj.method = 'post';
		obj.submit(); */
	});

	$('#email').on('change', function(){
		let optionVal = $('[id=email] :selected').val();		// :selected 앞에 한칸 띄워줘야됨(선택된 값 가져오기)
		if(optionVal !== '') $('#userDomail').val(optionVal).attr('readonly', true);
		else $('#userDomail').val('').focus().attr('readonly', false);
	});
});

function doubleCheckId(check) {
	if($('#userId').val() === undefined || $('#userId').val() === "" || $('#userId').val().length === 0 || $.trim($('#userId').val()) === "") {
		alert('ID를 입력하세요');
		$('#userId').focus();
		return false;
	}
	$.ajax({
		url : '/jhj2/user/doubleCheckId',
		data: 'userId=' + $('#userId').val(),
		success : function(data) {
			if(data) {
				alert('이미 가입된 ID입니다.')
				idCheck = false;
			} else {
				if(!check) alert('사용 가능한 ID입니다.')
				idCheck = true;
			}
		},
		error: function(e) {
			console.log('>>>>>>> :: ', e)
		}
	});
	return idCheck;
}

function validationCheck() {
	let isRight = true;
	let regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;	// email 유효성검사
	let regHan = /^[가-힣]{2,15}$/;																							// 한글 유효성검사(2자리 이상 15자리 이하)
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
		$('#userId').focus();
		return false;
	}

	if(!regHan.test($('#userNm').val())) {
		alert('2~10자 이내의 한글만 입력 가능합니다.');
		$('#userNm').focus();
		return false;
	}

	if(!regpw.test($('#userPw').val())) {
		alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~16자리 사용해야 합니다.');
		$('#userPw').focus();
		return false;
	}

	if($('#userPwCheck').val() !== $('#userPw').val()) {
		alert('비밀번호가 일치하지 않습니다.');
		$('#userPwCheck').val('');
		$('#userPwCheck').focus();
		return false;
	}

	if(!regEmail.test($("#userEmail").val() + '@' + $("#userDomail").val())) {
		alert("잘못된 Email 형식입니다.");
		$('#userDomail').val('');
		$('#userDomail').focus();
		return false;
	}

	if(!regPhone.test($("#userPhone").val())) {
		alert("전화번호는 숫자만 입력할 수 있으며, 올바른 형식이어야 합니다.");
		$('#userPhone').focus();
		return false;
	}

	return isRight;
}
</script>
<div class="wrap">
	<main>
		<h2>회원가입</h2>
		<form name="frm" id="frm">
		<!-- RSA -->
		<%-- <input type="hidden" id="RSAModulus" value="${RSAModulus}"/>
		<input type="hidden" id="RSAExponent" value="${RSAExponent}"/>
		<input type="hidden" name="hiddenPw" id="hiddenPw" /> --%>
			<div>
				<label for="userId">아이디 <span>*</span></label>
				<div>
					<input type="text" id="userId" name="userId" placeholder="ID 입력" data-name="아이디" maxlength="20" onKeyup="checkedId(this);" />
					<button type="button" onclick="doubleCheckId();">중복 확인</button>
				</div>
			</div>
			<div>
				<label for="userPw">비밀번호 <span>*</span></label>
				<input type="password" id="userPw" name="userPw" placeholder="비밀번호 입력" data-name="비밀번호" maxlength="16" autoComplete="off" />
			</div>
			<div>
				<label for="userPwCheck">비밀번호 확인 <span>*</span></label>
				<input type="password" id="userPwCheck" name="userPwCheck" placeholder="비밀번호 입력" data-name="비밀번호 확인" maxlength="16" autoComplete="off" />
			</div>
			<div>
				<label for="userNm">이름 <span>*</span></label>
				<input type="text" id="userNm" name="userNm" placeholder="이름 입력" data-name="이름" maxlength="25" />
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
						<option value="hanmail.co.kr">hanmail.co.kr</option>
					</select>
				</div>
			</div>
			<div>
				<label for="userPhone">전화번호 <span>*</span></label>
				<input type="text" id="userPhone" name="userPhone" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" data-name="전화번호" maxlength="20" onKeyup="checkedPhone(this);" />
			</div>
			<div>
				<label for="userZipCode">주소 <span>*</span></label>
				<input type="text" class="userZipCode" id="userZipCode" name="userZipCode" placeholder="클릭하세요" onclick="openDaumPostcode('userZipCode','userFirstAddr','userSecondAddr'); return false;" readonly="true" data-name="우편 번호" /><br>
				<input type="text" class="userAddr" id="userFirstAddr" name="userFirstAddr" placeholder="주소" readonly="readonly" data-name="주소" /><br>
				<input type="text" id="userSecondAddr" name="userSecondAddr" placeholder="나머지 주소" data-name="나머지 주소" maxlength="30" />
				<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
					<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
				</div>
			</div>
			<button class="join-btn" type="button" id="joinBtn">회원가입</button>
		</form>
	</main>
</div>

<script>
//우편번호 찾기 화면을 넣을 element
var element_layer = document.getElementById('layer');
function closeDaumPostcode() {
	// iframe을 넣은 element를 안보이게 한다.
	element_layer.style.display = 'none';
}

function openDaumPostcode(zipCode, firstAddr, secondAddr) {
	new daum.Postcode({
		oncomplete : function (data) {
			// document.getElementById(zipCode).value = data.zonecode;
			$('#'+zipCode).val(data.zonecode);

			// document.getElementById(firstAddr).value = data.address;
			if(data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				$('#'+firstAddr).val(data.roadAddress);
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				$('#'+firstAddr).val(data.jibunAddress);
			}
			// document.getElementById(secondAddr).focus();
			$('#'+secondAddr).focus();
			element_layer.style.display = 'none';
		},
		width : '100%',
		height : '100%'
}).embed(element_layer);
	element_layer.style.display = 'block';
	initLayerPosition();
}

function initLayerPosition() {
	var width = 300;			//우편번호서비스가 들어갈 element의 width
	var height = 460;			//우편번호서비스가 들어갈 element의 height
	var borderWidth = 5;		//샘플에서 사용하는 border의 두께

	// 위에서 선언한 값들을 실제 element에 넣는다.
	element_layer.style.width = width + 'px';
	element_layer.style.height = height + 'px';
	element_layer.style.border = borderWidth + 'px solid';
	// 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
	element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/16 - borderWidth) + 'px';
	element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}
</script>