<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>

<script>
/*
$(function(){
	let paramByData = {param :[]};
	let code = "1234";
	let type = "jsonData";
	let url = "testApiData";

	paramByData.param.push({'code':code});
	paramByData.param.push({'type':type});
	paramByData.param.push({'url':url});

	$.ajax({
		url : '/jyprac/pracAjax',
		type : 'post',
		data : JSON.stringify(paramByData), // 서버로 요청보내는 data의 형식은 json을 string으로 변환해서 보내준다..?
		headers : {'Content-Type' : 'application/json; charset=UTF-8'}, //클라이언트가 서버로 보내는 데이터 형식을 나타냄. /json형식
		dataType : 'json', //서버로 부터 받을 응답은 json을 기대한다.
		success : function(successTest){
			console.log('successTest::', successTest);
			alert("야호 뭔가 됬다 !");
		}
	});

}); */

/* $('#jiyeon').on('click',function(){ */
function jiyeonOnclick() {
	let data = $('#jiyeon').attr('id');

	$.ajax({
		url : '/jyprac/resultData',
		type : 'get',
		data: 'data=' + encodeURIComponent(data),
		async : false,
		dataType: 'int',
		beforeSend : function() {
		},
		success : function(response) {
			console.log('response::', response , typeof(response))

			let list = '';
			for(let x in response){
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

</script>

<div>
	<button id="jiyeon" onclick="jiyeonOnclick();">testApiData</button>
	<ul id="resultMap"></ul>
</div>

