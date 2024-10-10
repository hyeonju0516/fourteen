<script>
$(function() {
	$('#findUserPwBtn').on('click', function() {
		lodingBarStart();
		$.ajax({
			url: '/kcm/login/findUserPw',
			type: 'post',
			data: $("form[name=frm]").serialize(),
			success: function(data) {
				if(data.result) {
					alert("임시 비밀번호가 발급 되었습니다. 이메일을 확인해주세요.");
					location.replace("/kcm/login/login");
				} else {
					alert("입력한 정보가 올바르지 않습니다.");
					location.reload();
				}
				lodingBarEnd();
			},
			error: function(e) {
				console.log("로그인 실패 => ", e);
			}
		});
	});
});
</script>

<div class="wrap">
	<main>
		<h2>비밀번호 찾기</h2>
		<form name="frm">
			<div>
				<label for="userId">아이디 </label>
				<input type="text" id="userId" name="userId" placeholder="ID 입력" data-name="아이디" maxlength="20" required/>
			</div>
			<div>
				<label for="userNm">이름 </label>
				<input type="text" id="userNm" name="userNm" maxlength="20" required />
			</div>
			<div>
				<label for="userEmail">이메일 </label>
				<input type="text" id="userEmail" name="userEmail" maxlength="20" required />
			</div>
			<button type="button" id="findUserPwBtn">확인</button>
		</form>
	</main>
</div>