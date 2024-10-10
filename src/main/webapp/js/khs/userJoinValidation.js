let idCheck = false

$(function(){
    $('#joinBtn').on('click', function(){
        let validate = validationCheck();						// 발리 데이션 체크
        if(validate === false) return false;
        if(!idCheck) {
            alert('아이디 중복확인을 해주세요')
            return false;
            // return true;
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
            url : '/khs/user/join',
            type: 'post',
            // data: formData,
            data: $("form[name=frm]").serialize(),
            // contentType: false,
            // processData: false,
            dataType: 'json',
            success : function(data) {
                alert("정상가입되었습니다.");
                window.location.href= '/khsLogin/login';
            },
            error: function(e) {
                alert("비정상적 접근입니다. 다시 시도해주세요.");
            }
        });
    });

    $('#email').on('change', function(){
        let optionVal = $('[id=email] :selected').val();		// :selected 앞에 한칸 띄워줘야됨(선택된 값 가져오기)
        if(optionVal !== '') $('#userDomain').val(optionVal).attr('readonly', true);
        else $('#userDomain').val('').focus().attr('readonly', false);
    });
});
function doubleCheckId(check) {
    if($('#userId').val() === undefined || $('#userId').val() === "" || $('#userId').val().length === 0 || $.trim($('#userId').val()) === "") {
        alert('ID를 입력하세요');
        $('#userId').focus();
        return false;
    }
    $.ajax({
        url : '/khs/user/join/idckeck',
        data: 'userId=' + $('#userId').val(),
        success : function(data) {
            if(data != 0) {
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
            if($(this).attr('id') === 'userDomain' && $('[id=email] :selected').val() !== '') {
                isRight = true;
            } else {
                alert($(this).attr('data-name') + ' 항목을 입력하세요.');
                $(this).focus();
                isRight = false;
                return false;
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

    if(!regEmail.test($("#userEmail").val() + '@' + $("#userDomain").val())) {
        alert("잘못된 Email 형식입니다.");
        $('#userDomain').val('');
        $('#userDomain').focus();
        return false;
    }

    if(!regPhone.test($("#userPhone").val())) {
        alert("전화번호는 숫자만 입력할 수 있으며, 올바른 형식이어야 합니다.");
        $('#userPhone').focus();
        return false;
    }

    return isRight;
}