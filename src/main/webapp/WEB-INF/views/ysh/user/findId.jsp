<script>
function findIdCheck() {
    alert('findIdCheck');

    $.ajax({
        url : '/ysh/user/findIdCheck',
        type : 'get',
        data : 'userName=' + encodeURIComponent($('#userName').val()),
        dataType : 'json',
        success : function(data) {
            alert('success');
            console.log('data 확인 ::' + data);
            console.log('data.result 확인 ::' + data.result);
            if(data.result != null) alert($('#userName').val() + '님의 아아디는 ' + data.result + '입니다,');
            else alert('가입 정보를 찾을 수 없습니다.');
        }
    });
}
</script>
<div class="wrap">
   <main>
      <h2>아이디 찾기</h2>
      <form name="findId" id="findId" action="#" method="post">
         <div>
            <label for="userId">아이디 <span>*</span></label>
            <div>
               <input type="text" id="userName" name="userName" placeholder="이름 입력" required />
               <button type="button" onclick="findIdCheck();">아이디 찾기</button>
            </div>
            <span class="warning">아이디를 입력해주세요.</span>
         </div>
      </form>
   </main>
</div>
