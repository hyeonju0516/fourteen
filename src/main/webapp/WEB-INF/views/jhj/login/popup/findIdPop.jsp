<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 찾기</title>
<link rel="stylesheet" href="path/to/your/css/file.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<script>
$(document).ready(function() {
    $('#findIdBtn').on('click', function() {
		let validate = validationCheck();
		if (validate === false) {
			return false;
		}

		$.ajax({
		url: '/jhj/login/findIdProcess',
		type: 'post',
		data: $("form[name=frm]").serialize(),
		success: function(response) {
 			if (response.idList != null) {
				var form = $('<form>', {
					action: '/jhj/login/findIdResultPop',
					method: 'post'
				}).append($('<input>', {
					type: 'hidden',
					name: 'idList',
					value: response.idList
				}));

				$('body').append(form);
				form.submit();
			} else {
				alert('입력한 정보와 일치하는 아이디가 없습니다.');
			}
		},
		error: function(e) {
			console.log('Error :: ', e);
			alert('아이디 찾기 요청 중 오류가 발생했습니다.');
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
	let regHan = /^[가-힣]{2,15}$/;																							// 한글 유효성검사(2자리 이상 15자리 이하)
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

	if(!regHan.test($('#userNm').val())) {
		alert('2~10자 이내의 한글만 입력 가능합니다.');
		$('#userNm').focus();
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


<body>
	<div class="otpDiv">
	<h4>&nbsp;&nbsp;&nbsp;아이디 찾기</h4>
		<form name="frm" id="frm">
			<div>
				<label for="userNm">이름 <span>*</span></label>
				<input type="text" id="userNm" name="userNm" placeholder="이름 입력" data-name="이름" maxlength="25" />
			</div>
			<div>
				<label for="userPhone">전화번호 <span>*</span></label>
				<input type="text" id="userPhone" name="userPhone" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" data-name="전화번호" maxlength="20" onKeyup="checkedPhone(this);" />
			</div>
			<button class="btn btn-success btnType1 a2" type="button" id="findIdBtn">아이디 찾기</button>
		</form>
	</div>
</body>
</html>
