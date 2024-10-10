<style>
.userZipCode {
    width: 23% !important;
}
.userZipCode, .userAddr {
    margin-bottom: 10px;
}
</style>
<script>
function idDoubleCheckInt() {
    alert('idDoubleCheckInt 진입');
    let userId = $('#userId').val();

    $.ajax({
        url : '/yshPractice/user/idDoubleCheckInt',
        type : 'GET',
        data : {userId : userId},
        success : function(data) {
            console.log('data :' + data)
            if(data == 1) {
                alert('중복된 아이디 입니다.');
            } else {
                alert('사용가능한 아이디 입니다.');
                $('#userPw').focus();
            }
        }
    });
}
</script>
<div class="wrap">
    <main>
        <h2>회원가입</h2>
        <form name="join" id="join" action="#" method="post">
            <div>
                <label for="userId">아이디 <span>*</span></label>
                <div>
                    <input type="text" id="userId" name="userId" placeholder="ID 입력" required />
                    <button type="button" onclick="idDoubleCheckInt();">중복 확인</button>
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
                        <option value="naver.com">naver.com</option>
                        <option value="kakao.com">kakao.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="hanmail.co.kr">hanmail.co.kr</option>
                    </select>
                </div>
                <span class="warning">이메일을 입력해주세요.</span>
            </div>
            <div>
                <label for="userNumber">전화번호 <span>*</span></label>
                <input type="text" id="userNumber" name="userNumber" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" required />
                <span class="warning">전화번호를 입력해주세요.</span>
            </div>
            <div>
                <label for="userZipCode">주소 <span>*</span></label>
                <input type="text" class="userZipCode" id="userZipCode" name="userZipCode" placeholder="클릭하세요" onclick="openDaumPostcode('userZipCode','userFirstAddr','userSecondAddr'); return false;" readonly="true" required /><br>
                <input type="text" class="userAddr" id="userFirstAddr" name="userFirstAddr" placeholder="주소" readonly="readonly" required /><br>
                <input type="text" id="userSecondAddr" name="userSecondAddr" placeholder="나머지 주소" required />
                <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
                    <img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
                </div>
            </div>
            <button class="join-btn" type="button">회원가입</button>
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
    var width = 300;         //우편번호서비스가 들어갈 element의 width
    var height = 460;         //우편번호서비스가 들어갈 element의 height
    var borderWidth = 5;      //샘플에서 사용하는 border의 두께

    // 위에서 선언한 값들을 실제 element에 넣는다.
    element_layer.style.width = width + 'px';
    element_layer.style.height = height + 'px';
    element_layer.style.border = borderWidth + 'px solid';
    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
    element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/16 - borderWidth) + 'px';
    element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}
</script>