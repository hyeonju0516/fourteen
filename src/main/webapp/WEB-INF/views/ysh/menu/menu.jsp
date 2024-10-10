<script>
function logout() {
    $.ajax({
        url : '/ysh/logout',
        type : 'GET',
        success : function(response) {
            alert('로그아웃 성공!!')
            window.location.href = '/ysh/main';
        },
        error : function(e) {
            console.log('e : ' + e)
        }
    });
}
</script>

<header>
    <div class="inner">
        <div class="hd-contents">
            <div class="logo" id="">LOGO</div>
            <jsp:include page="/ysh/menu/mainTopMenuList" />
            <ul class="sns">
                <c:choose>
                    <c:when test="${login}">
                        <li class="sns-list">${userId}님</li>
                        <li class="sns-list"><button type="button" onclick="logout()">로그아웃</button></li>
                    </c:when>
                    <c:otherwise>
                        <li class="sns-list"><a href="/ysh/user/login">로그인</a></li>
                        <li class="sns-list"><a href="/ysh/user/join">회원가입</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <button class="mb-nav" type="button">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </div>
</header>