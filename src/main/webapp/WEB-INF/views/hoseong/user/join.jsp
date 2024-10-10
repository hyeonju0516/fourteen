<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css' />" />
<style>
    .userZipCode {
        width: 23% !important;
    }
    .userZipCode, .userAddr {
        margin-bottom: 10px;
    }
</style>
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
                    <input type="text" id="userDomain" name="userDomain" placeholder="직접 입력" data-name="도메인" maxlength="15" />
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
                <input type="text" id="userPhone" name="userPhone" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" data-name="전화번호" maxlength="20"
<%--                       onKeyup="checkedPhone(this);" --%>
                />
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
<script src="<c:url value='/js/khs/userJoinValidation.js' />"></script>
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>