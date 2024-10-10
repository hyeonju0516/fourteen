<div class="w3-content w3-container w3-margin-top">
	<div class="w3-container w3-card-4">
		<form action="../login/findId" method="post">
			<div class="w3-center w3-large w3-margin-top">
				<h3>아이디 찾기</h3>
			</div>
			<div>
				<p>
					<label>핸드폰 번호</label>
					<input class="w3-input" type="text" name="userPhone" placeholder="핸드폰번호를 입력하세요." required>
				</p>
				<p class="w3-center">
					<button type="submit" id=findBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">find</button>
					<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
				</p>
			</div>
		</form>
	</div>
</div>