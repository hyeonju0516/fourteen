function checkedId(obj) {
	let str = obj.value;
	let len = str.length;
	let ch = str.charAt(0);
	let lastStr = '';
	for(let i = 0; i < len; i++) {
		ch = str.charAt(i);
		lastStr += str.charAt(i);
		if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			continue;
		} else {
			obj.value = lastStr.substring(0, lastStr.length-1);
			alert("영문/숫자만 입력이 가능합니다.");
			obj.focus();
			return false;
		}
	}
	return true;
}

function checkedPhone(obj) {
	let str = obj.value;
	let len = str.length;
	let ch = str.charAt(0);
	let lastStr = '';
	for(let i = 0; i < len; i++) {
		ch = str.charAt(i);
		lastStr += str.charAt(i);
		if(ch >= '0' && ch <= '9') {
			continue;
		} else {
			obj.value = lastStr.substring(0, lastStr.length-1);
			alert("숫자만 입력이 가능합니다.");
			obj.focus();
			return false;
		}
	}
	return true;
}

function checkedNumber(obj) {
	let str = obj.value;
	let len = str.length;
	let ch = str.charAt(0);
	let lastStr = '';
	for(let i = 0; i < len; i++) {
		ch = str.charAt(i);
		lastStr += str.charAt(i);
		if(ch >= '0' && ch <= '9') {
			continue;
		} else {
			obj.value = lastStr.substring(0, lastStr.length-1);
			alert("숫자만 입력이 가능합니다.");
			obj.focus();
			return false;
		}
	}
	return true;
}

function lodingBarStart() {
	var loading = $('<div id="loading" class="loading"></div><img id="loading_img" alt="loading" src="/img/viewLoading.gif" />').appendTo(document.body).hide();
	loading.show();
}

function lodingBarEnd() {
	$("#loading").remove();		// 로딩바 종료
	$("#loading_img").remove();	// 로딩바 종료
}

function showTimer() {
	let time = 180;
	let min = "";
	let sec = "";

	clearTimer();

	interval = window.setInterval(function(){
		min = parseInt(time / 60);
		sec = time % 60;
		document.getElementById("timerArea").innerHTML = min + "분" + sec + "초";
		time --;
		if(time < 0) {
			clearTimer();
			document.getElementById("timerArea").innerHTML = "인증시간 만료";
		}
	}, 1000);
}

function clearTimer() {
	window.clearInterval(interval);
	interval = null;
}

function successAlert(title, content){
	$.alert({
		type : 'green',
		title : title,
		content : content,
		buttons : {
			confirm : {
				text : '확인'
			}
		}
	});
}

function errorAlert(title, content){
	$.alert({
		type : 'red',
		title : title,
		content : content,
		buttons : {
			confirm : {
				text : '확인'
			}
		}
	});
}