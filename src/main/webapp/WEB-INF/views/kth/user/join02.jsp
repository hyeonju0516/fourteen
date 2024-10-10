<script>
    $(function() {

        let idChecked = false;

        $('#joinBtn').on('click', function() {
            let validate = validationCheck();
            if(validate === false) return false;
            if(!idChecked) {
                alert("아이디 중복확인을 확인해주세요.");
                return false;
            }

            if(confirm('회원가입을 진행하시겠습니까?') === true) {



                $.ajax({
                    url: '/kth/user/joinCheck',
                    type: 'POST',
                    data: $('#join').serialize(),
                    success: function(data) {
                        console.log(data);
                        alert('회원가입이 정상적으로 처리되었습니다.');
                    },
                    error: function(xhr, status, error) {
                        console.log(error);
                    }
                });
            }
        });

        $('#email').on('change', function() {
            if($('#email option:selected').val() !== '') $('#userDomain').val($('#email option:selected').val()).attr('readonly', true);
            else $('#userDomain').val('').focus().attr('readonly', false);
        });

        $('#idCheckBtn').on('click', function() {

            if($('#userId').val() === null || $('#userId').val().trim() === '' || $('#userId').val() === undefined || $('#userId').val().length === 0) {
                alert("아이디가 공백입니다.");
                $('#userId').focus();
                return false;
            }

            $.ajax({
                url: '/kth/user/doubleCheckId2',
                type: 'GET',
                data: 'userId=' + $('#userId').val(),
                success: function(result) {
                    console.log(result);
                    if(result > 0) {
                        alert('아이디가 중복');
                        idChecked = false;
                    }else {
                        alert('아이디 사용가능');
                        idChecked = true;
                    }
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });

            return idChecked;
        });

        function validationCheck() {

            let isRight = true;
            let regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;	// email 유효성검사
            let regHan = /^[가-힣]{2,15}$/;																							// 한글 유효성검사(2자리 이상 15자리 이하)
            let regId = /^(?!.*([a-zA-Z0-9])\1{4})[a-zA-Z0-9]{4,20}$/;																// 4~20자 이내의 영문,숫자 아이디 (특문 X) , 공백 안됨 , 동일한 5자 이상 안됨
            let regpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;														// 비밀번호 영문자+숫자+특수조합(8~16자리 입력) 정규식
            // let phoneChecked = /^[0-9-]{1,16}$/;
            let regPhone = /^(01[016789]{1})[0-9]{3,4}[0-9]{4}$/;

            $('#join').find('input').each(function(i, items) {

                if($(this).val() === null || $(this).val().trim() === '' || $(this).val() === undefined || $(this).val().length === 0) {
                    if($(this).attr('id') === 'userDomain' && $('#email option:selected').val() !== '') {
                        isRight = true;
                    }else{
                        alert($(this).attr('data-name') + ' 항목을 입력하세요.');
                        $(this).focus();
                        isRight = false;
                        return false;
                    }
                }
            });

            if(!isRight) return false;

            if(!regId.test($('#userId').val())) {
                alert('알맞은 형식의 아이디가 아닙니다.');
                $('#userId').focus();
                return false;
            }
            if(!regpw.test($('#userPw').val())) {
                alert('알맞은 형식의 비밀번호가 아닙니다.');
                $('#userPw').focus();
                return false;
            }
            if($('#userPwCheck').val() !== $('#userPw').val()) {
                alert("패스워드가 일치하지 않습니다.")
                $('#userPwCheck').focus();
                return false;
            }
            if(!regHan.test($('#userNm').val())) {
                alert("알맞은 형식의 이름이 아닙니다.");
                $('#userNm').focus();
                return false;
            }
            if(!regEmail.test($('#userEmail').val() + '@' + $('#userDomain').val())) {
                alert("알맞은 형식의 이메일이 아닙니다.");
                $('#userEmail').focus();
                return false;
            }
            if(!regPhone.test($('#userPhone').val())) {
                alert("알맞은 형식의 전화번호가 아닙니다.");
                $('#userPhone').focus();
                return false;
            }

            return isRight;
        }
    });
</script>

<div class="wrap">
    <main>
        <h2>회원가입</h2>
        <form name="join" id="join" action="#" method="post">
            <!--<input type="hidden" id="RSAModulus" name="RSAModulus" data-name="RSAModulus" value="${RSAModulus}" />-->
            <!--<input type="hidden" id="RSAExponent" name="RSAExponent" data-name="RSAExponent" value="${RSAExponent}" />-->
            <div>
                <label for="userId">아이디 <span>*</span></label>
                <div>
                    <input type="text" id="userId" name="userId" data-name="유저 아이디" placeholder="ID 입력" required />
                    <button type="button" id="idCheckBtn">중복 확인</button>
                </div>
                <span class="warning">아이디를 입력해주세요.</span>
            </div>
            <div>
                <label for="userPw">비밀번호 <span>*</span></label>
                <input type="password" id="userPw" name="userPw" data-name="유저 비밀번호" placeholder="비밀번호 입력" autocomplete="off" required />
                <span class="warning">비밀번호를 입력해주세요.</span>
            </div>
            <div>
                <label for="userPw">비밀번호 확인 <span>*</span></label>
                <input type="password" id="userPwCheck" name="userPwCheck" data-name="유저 비밀번호 확인" placeholder="비밀번호 입력" required />
                <span class="warning">비밀번호가 일치하지 않습니다.</span>
            </div>
            <div>
                <label for="userNm">이름 <span>*</span></label>
                <input type="text" id="userNm" name="userNm" data-name="유저 이름" placeholder="이름 입력" required />
                <span class="warning">이름을 입력해주세요.</span>
            </div>
            <div>
                <label for="userEmail">이메일 <span>*</span></label>
                <div>
                    <input type="text" id="userEmail" name="userEmail" data-name="유저 이메일" placeholder="이메일 입력" required />
                    <span>@</span>
                    <input type="text" id="userDomain" name="userDomain" data-name="유저 도메인" placeholder="직접 입력" required />
                    <select name="email" id="email">
                        <option value="">직접 입력</option>
                        <option value="naver.com">naver.com</option>
                        <option value="kakao.com">kakao.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="hanmail.com">hanmail.co.kr</option>
                    </select>
                </div>
                <span class="warning">이메일을 입력해주세요.</span>
            </div>
            <div>
                <label for="userPhone">전화번호 <span>*</span></label>
                <input type="text" id="userPhone" name="userPhone" data-name="유저 전화번호" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" required />
                <span class="warning">전화번호를 입력해주세요.</span>
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
            <button class="join-btn" id="joinBtn" type="button">회원가입</button>
        </form>
    </main>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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