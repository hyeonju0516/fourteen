<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="/js/swiper.js"></script>
<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
<script>
	AOS.init();
</script>
<header>
	<div class="inner">
		<div class="hd-contents">
			<div class="logo" id="">LOGO</div>
			<jsp:include page="/ysh/menu/mainTopMenuList" />
			<ul class="sns">
				<li class="sns-list"><a href="#">twitter</a></li>
				<li class="sns-list"><a href="#">twitter</a></li>
			</ul>
			<button class="mb-nav" type="button">
				<span></span>
				<span></span>
				<span></span>
			</button>
		</div>
	</div>
</header>

<main>
	<section class="sc main-visual-section">
		<div class="sc-inner visual">
			<div class="sc-contents main-desc">
				<h4 class="intro">세현 문의 게시판 Nothing yet...</h4>
			</div>
		</div>
	</section>
</main>
<script src="/js/main02.js"></script>
<script src="/js/main02.js"></script>
<%@ include file="/WEB-INF/include/include-footer.jsp"%>