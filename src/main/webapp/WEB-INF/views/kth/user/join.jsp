    <link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css' />" />
<script>
    function doubleCheckId() {
        $.ajax({
            url: '/kth/user/doubleCheckId',
            type: 'GET',
            data: 'userId=' + $('#userId').val(),
            success: function(data) {
                if(data == 1) alert("있음");
                else alert("없음");
            },
            error: function(xhr, status, error) {
                console.error('error : ', error);
            }
        })
    }
</script>
<header>
	<div class="inner">
	<div class="hd-contents">
		<div class="logo">LOGO</div>
		<jsp:include page="/menu/mainTopMenuList" />
		<ul class="sns">
		<li class="sns-list"><a href="#" class="param" onclick="onclickMethod('data');" id="param">kakao</a></li>
		<li class="sns-list"><a href="#" class="param" id="param2">twitter</a></li>
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
        <h2>회원가입</h2>
        <form name="join" id="join" action="#" method="post">
            <div>
                <label for="userId">아이디 <span>*</span></label>
                <div>
                    <input type="text" id="userId" name="userId" placeholder="ID 입력" required />
                    <button type="button" onclick="doubleCheckId();">중복 확인</button>
                </div>
                <span class="warning">아이디를 입력해주세요.</span>
            </div>
            <div>
                <label for="userPw">비밀번호 <span>*</span></label>
                <input type="password" id="userPw" name="userPw" placeholder="비밀번호 입력" required />
                <span class="warning">비밀번호를 입력해주세요.</span>
            </div>
            <div>
                <label for="userPw">비밀번호 확인 <span>*</span></label>
                <input type="password" id="userPwCheck" name="userPwCheck" placeholder="비밀번호 입력" required />
                <span class="warning">비밀번호가 일치하지 않습니다.</span>
            </div>
            <div>
                <label for="userName">이름 <span>*</span></label>
                <input type="text" id="userName" name="userName" placeholder="이름 입력" required />
                <span class="warning">이름을 입력해주세요.</span>
            </div>
            <div>
                <label for="userEmail">이메일 <span>*</span></label>
                <div>
                    <input type="text" id="userEmail" name="userEmail" placeholder="이메일 입력" required />
                    <span>@</span>
                    <input type="text" id="userDomail" name="userDomail" placeholder="직접 입력" required />
                    <select name="email" id="email">
                        <option value="naver">naver.com</option>
                        <option value="kakao">kakao.com</option>
                        <option value="gmail">gmail.com</option>
                        <option value="hanmail">hanmail.co.kr</option>
                    </select>
                </div>
                <span class="warning">이메일을 입력해주세요.</span>
            </div>
            <div>
                <label for="userNumber">전화번호 <span>*</span></label>
                <input type="text" id="userNumber" name="userNumber" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" required />
                <span class="warning">전화번호를 입력해주세요.</span>
            </div>
            <div class="addr">
                <div>
                    <input type="text" id="sample6_postcode" placeholder="우편번호">
                    <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                </div>
                <input type="text" id="sample6_address" placeholder="주소"><br>
                <input type="text" id="sample6_detailAddress" placeholder="상세주소">
                <input type="text" id="sample6_extraAddress" placeholder="참고항목">
            </div>
            <button class="join-btn" type="button">회원가입</button>
        </form>
    </main>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;

                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>


