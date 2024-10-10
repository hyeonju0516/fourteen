<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css' />" />
<script>
$(function(){
    if(message) {
        alert(message)
    }
});

function loginBtn() {
    alert('loginBtn')

    let validate = validationCheck();

    if(!validate) return false;

    $.ajax({
        url : '/ysh/user/loginRequest',
        type : 'POST',
        data : $('#loginForm').serialize(),
        success : function(response) {
            console.log('response : ', response);
            if(response.userId != null) {
                alert('로그인에 성공했습니다.')
                window.location.href = '/ysh/main';
            }
        },
        error : function(e) {
            console.log('e : ', e)
        }
    });
}

function validationCheck() {
    let isRight = true;
    let regId = /^(?!.*([a-zA-Z0-9])\1{4})[a-zA-Z0-9]{4,20}$/;																// 4~20자 이내의 영문,숫자 아이디 (특문 X) , 공백 안됨 , 동일한 5자 이상 안됨
    let regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;														// 비밀번호 영문자+숫자+특수조합(8~16자리 입력) 정규식																// 숫자만 입력하는 정규식

    // 공백체크(index : 순번, item : 해당 tag 내용)
    $('#loginForm').find('input').each(function(index, item) {
        if($(this).val() === null || $.trim($(this).val()) === ''|| $(this).val() === 'undefined' || $(this).val().length === 0) {
            alert($(this).attr('data-name') + '을/를 입력하세요.');
            $(this).focus();

            // return false;    // each문 안에서는 return false; 가 안 먹힌다

            isRight = false;    // false 사용하기 위해서 변수에 할당한다.
            return isRight;     // 변수를 리턴한다.
        }
    });

    if(!isRight) return false;

    if(!regId.test($('#userId').val()) || !regPw.test($('#userPw').val())) {
        alert('아이디와 비밀번호의 정보가 일치하지 않습니다.');
        return false;
    }

    return isRight;
}
</script>

<div class="wrap">
    <main>
        <h2>로그인</h2>
        <form name="loginForm" id="loginForm">
            <div>
                <label for="userId">아이디 </label>
                <input type="text" id="userId" name="userId" data-name="아이디" required />
            </div>
            <div>
                <label for="userPw">비밀번호 </label>
                <input type="password" id="userPw" name="userPw" data-name="비밀번호" required />
            </div>
            <button type="button" onclick="loginBtn();">로그인</button>
        </form>
        <ul class="find_wrap">
            <li><a href="#">아이디 찾기</a></li>
            <li><a href="#">비밀번호 찾기</a></li>
            <li><a href="/ysh/user/join">회원가입</a></li>
        </ul>
    </main>
</div>
