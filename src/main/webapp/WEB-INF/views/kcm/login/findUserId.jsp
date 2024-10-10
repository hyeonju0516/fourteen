<script>
$(function() {
	$('#findUserIdBtn').on('click', function() {
		lodingBarStart();
		$.ajax({
			url: '/kcm/login/findUserId',
			type: 'post',
			data: $("form[name=frm]").serialize(),
			success: function(data) {
				if(data.result) {
					alert("이메일을 확인해주세요.");
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
		<h2>아이디 찾기</h2>
		<form name="frm">
			<div>
				<label for="userNm">이름 </label>
				<input type="text" id="userNm" name="userNm" maxlength="20" required />
			</div>
			<div>
				<label for="userEmail">이메일 </label>
				<input type="text" id="userEmail" name="userEmail" maxlength="20" required />
			</div>
			<div>
				<label for="userPhone">전화번호 </label>
				<input type="text" id="userPhone" name="userPhone" placeholder="휴대폰 번호 입력 ('-' 제외 11자리 입력)" maxlength="20" />
			</div>

			<button type="button" id="findUserIdBtn">확인</button>
		</form>
	</main>
</div>