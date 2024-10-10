<link rel="stylesheet" type="text/css" href="<c:url value='/css/history.css' />" />
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="/js/swiper.js"></script>
<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
<script>
	AOS.init();
	function onclickMethod() {
		//alert(888);
	}
</script>

<main>
<section class="sc main-visual-section">
		<h1 class="sc-tt">메인 비주얼 섹션</h1>
		<div class="sc-inner visual">
			<div class="sc-contents main-desc">
				<h4 class="intro">회사연혁</h4>
				<p><span class="highlight">스마트 웹사이트</span> 플랫폼입니다.</p>
			</div>
		</div>
	</section>

	<section class="history">
		<h1 class="sc-tt">기능 섹션</h1>
		<c:if test="${not empty historyList}">
			<ul class="his_list">
				<c:forEach var="EseHistoryVo" items="${historyList}" varStatus="idx">
					<li>
						<div class="year">
							<strong>${EseHistoryVo.year}</strong>
							<div class="img">
								<img src="/img/sub/his_2021.jpg" alt="">
							</div>
						</div>
						<div class="txt">
							<ul>
							  <li>${EseHistoryVo.event}</li>
							</ul>
						</div>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${empty historyList}">
		    <p>No history data available.</p>
		</c:if>
	</section>
</main>
<script src="/js/main02.js"></script>
