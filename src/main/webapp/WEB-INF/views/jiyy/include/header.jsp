<%@ include file="/WEB-INF/include/include-header.jsp"%>

<header>
	<div class="inner">
		<div class="hd-contents">
			<div class="logo">LOGO</div>
			<jsp:include page="/jyMenu/mainTopMenu" />
			<ul class="sns">
				<li class="sns-list"><a href="/jy/login">로그인</a></li>
				<li class="sns-list"><a href="/jy/logout">로그아웃</a></li>
			</ul>
			<button class="mb-nav" type="button">
				<span></span>
				<span></span>
				<span></span>
			</button>
		</div>
	</div>
</header>