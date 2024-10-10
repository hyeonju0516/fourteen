<script>
function idSearching() {
    alert('idSearching 진입');

    $.ajax({
        url : '/yshPractice/search/idSearching',
        type : 'GET',
        data : {userId : $('#userId').val()},
        success : function(data) {
            console.log('data :' + data)
            if(data === 1) {
                alert('존재하는 ID입니다.');
            } else {
                alert('ID를 찾을 수 없습니다.');
            }
        }
    });
}
</script>
<div class="wrap">
    <main>
        <h2>아이디 조회</h2>
        <form name="idSearch" id="idSearch" action="#" method="get">
            <div>
                <label for="userId">아이디 <span>*</span></label>
                <div>
                    <input type="text" style="display: none;" />
                    <input type="text" id="userId" name="userId" placeholder="ID 입력" required />
                    <button type="button" onclick="idSearching();">검색</button>
                </div>
                <span class="warning">아이디를 입력해주세요.</span>
            </div>

        </form>
    </main>
</div>
