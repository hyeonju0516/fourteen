<script>
    function getAbc() {
        alert('joinChecking 진입');

        let userName = $('#userName').val();

        $.ajax({
            url : '/yshPractice/search/idSearch/joinChecking',
            type : 'GET',
            data : 'userNm=' + $('#userName').val(),
            success : function(data) {
                console.log('userNm :' + data)
            }
        });
    }
    function postAbc() {
        console.log('123213');
        let data = {
            userId: $('#userName').val()
        }

        $.ajax({
            url : '/yshPractice/search/idSearch/joinChecking',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            processData: false,
            success: function(response) {
                console.log(response);
            }
        })
    }
</script>
<div class="wrap">
    <main>
        <h2>아이디 찾기</h2>
        <form name="joinCheck" id="joinCheck" action="#" method="post">
            <div>
                <label for="userId">아이디 <span>*</span></label>
                <div>
                    <input type="text" style="display: none;" />
                    <input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" required />
                    <button type="button" onclick="getAbc();">get찾기</button>
                </div>
                <button type="button" onclick="postAbc();">post찾기</button>
                <span class="warning">아이디를 입력해주세요.</span>
            </div>

        </form>
    </main>
</div>
