<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
	<p>푸터 영역</p>
</div>
<style>
body, h1, ul, li, p {
	margin: 0;
	padding: 0;
}


.header {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 20px 0;
}


.menubar {
	background-color: skyblue;
	overflow: hidden;
}

.menubar ul {
	list-style-type: none;
	margin-left: 10px;
}

.menubar ul li {
	float: left;
	margin-left: 20px;
}

.menubar ul li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
}

.menubar ul li a:hover {
	color: red;
}


.content {
	padding: 20px;
	min-height: 733px;
}


.footer {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px 0;
	position: relative;
	bottom: 0;
	width: 100%;
}
</style>