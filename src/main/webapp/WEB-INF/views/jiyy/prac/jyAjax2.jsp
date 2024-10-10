<style>
.jyInner {
	width: 80%;
	margin: 200px auto;
	height: 300px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.jyInner ul {
	margin: 20px
}

.jyInner button {
	padding: 10px;
	background-color: tomato;
	border: 0;
	border-radius: 10px;
	color: #fff;
	font-size: 1rem;
	cursor: pointer;
}

.jyInner input {
	padding: 14px;
	border: 0;
	border-radius: 10px;
}
</style>

<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>

<script>
	function jiyeonOnclick() {
/* 		alert('jiyeonOnclick()진입') */
		let data = $('#jiyeon').attr('id');

		$.ajax({
			url : '/jyAjax/data',
			type : 'get',
			data : 'jyData=' + encodeURIComponent(data),
			async : false,
			dataType : 'json',
			beforeSend : function() {
				alert('before');
			},
			success : function(response) {
				alert('success');
				console.log('response::', response, typeof (response))

				let list = '';
				for ( let x in response) {
					list += `<li>${"${response[x].menuNm}"}</li>`;
					console.log(response[x].menuNm)
					console.log('<li> ${response[x].menuNm} </li>')
				}

				$('#resultMap').html(list);
			},
			complete : function() {
			}
		});
	}

	function userIdCheck(){
		console.log("userIdCheck!");

		$.ajax({
			url: "jyAjax/userId",
			type: "get",
			data: "userId=" + $("#userId").val(), //내가 보낼 데이테- value에 입력된 아이디
			dataType: "json",
			beforeSend: function(){
				console.log("before");
			},
			success: function(userId){
				console.log($("#userId").val());
				console.log("userId.result:::"+userId.result)
				console.log("userId:::"+userId)
				if(userId.result) alert("중복아이디가 있습니다.")
				else alert("사용가능한 아이디 입니다.")
				$("#userId").val("");
			},
			error: function(){
				console.log("데이터를 불러오지 못했다.")
			},
		});
	};
</script>

<div class="jyInner">
	<button id="jiyeon" onclick="jiyeonOnclick();">testApiData</button>
	<ul id="resultMap"></ul>

	<div>
		<label for="userId"></label> <input id="userId" type="text" />
		<button onClick="userIdCheck();">중복확인</button>
	</div>
</div>

