<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="/js/swiper.js"></script>
<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
<script>
AOS.init();

$(document).ready(function() {
	// 서버로 세션 상태 확인 요청을 보냄
	$.ajax({
		url: '/jhj/main/checkSessionProcess',
		type: 'GET',
		success: function(response) {
			if (response.status != 'authenticated') {
				// 세션이 없는 경우, 회원가입 페이지로 리다이렉트
				alert("로그인 후 메인페이지에 접속하세요");
				window.location.href = '/jhj/user/joinPage';
			}
		},
		error: function(error) {
			console.log("Error:", error);
		}
	});
});

$(function(){

	let paramByData = {param :[]};
	let code = '1234';
	let type = 'jsonData';
	let url = 'testApiData';

	paramByData.param.push({'code': code});
	paramByData.param.push({'type': type});
	paramByData.param.push({'url': url});


	$.ajax({
		url : '/testApiData',
		type : 'post',
		data: JSON.stringify(paramByData),
		headers : {'Content-Type' : 'application/json; charset=UTF-8'},
		dataType : 'json',
		success : function(result) {
			console.log('result :: ', result)
			/* $('.resultMap').html(
				'<span> ID : ' + result.resultData.url + '</span><br><br>'
				+ '<span> AGE : ' + result.resultData.age + '</span><br><br>'
				+ '<span> TEL : ' + result.resultData.tel + '</span><br><br>'
				+ '<span> MESSAGE : ' + result.resultData.message + '</span>'
			); */
		}
	});

	// $('#param2').click(function(){
	$('#param2').on('click', function(){
		let data = $('#param').html();
		// let param = document.getElementById('param').html;
		// let param = $(".param:eq(3)").html();

		$.ajax({
			url : '/requestCall',
			type : 'post',
			data: 'data=' + encodeURIComponent(data),
			async : false,
			dataType: 'text',
			// headers : {'Content-Type' : 'application/json; charset=UTF-8'},
			beforeSend : function() {
			},
			success : function(result) {
				$('.resultMap').html('<button type="button" class="" id="resultBtn">ë²í¼</button>');
			},
			complete : function() {
			}
		});
	});

	$(document).on('click', '#resultBtn', function(){
		alert(888)
	});
});

function onclickMethod(asdfafds) {
	let data = $('#param').html();
	// let param = document.getElementById('param').html;
	// let param = $(".param:eq(3)").html();

	$.ajax({
		url : '/requestCall',
		type : 'post',
		/*	encodeURIComponent
		ìë¥¼ë¤ì´, http://a.com?name=egoing&job=progr&ammer ìì &job=programmer ì¤ '&'ë íëì íë¼ë¯¸í°ê° ëëê³  ë¤ì íë¼ë¯¸í°ê° ì¨ë¤ë ìë¯¸ì´ë¤.
		ê·¸ë°ë° ë¤ìê³¼ ê°ì´ jobì ê°ì &ê° í¬í¨ëë¤ë©´ ìì¤íì jobì ê°ì ì ëë¡ ì¸ìí ì ìê² ëë¤. */
		data: 'data=' + encodeURIComponent(data),
		async : false,
		dataType: 'text',
		// headers : {'Content-Type' : 'application/json; charset=UTF-8'},
		beforeSend : function() {
		},
		success : function(result) {

		},
		complete : function() {
		}
	});
}
</script>
<header>
	<div class="inner">
		<div class="hd-contents">
			<div class="logo resultMap">LOGO</div>
			<jsp:include page="/menu/mainTopMenuList" />
			<ul class="sns">
				<li class="sns-list"><a href="#" class="param" onclick="onclickMethod('${data }');" id="param">kakao</a></li>
				<li class="sns-list"><a href="#" class="param" id="param2">twitter1</a></li>
				<li class="sns-list"><a href="#" class="param">twitter2</a></li>
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
		<h1 class="sc-tt">ë©ì¸ ë¹ì£¼ì¼ ì¹ì</h1>
		<div class="sc-inner visual">
			<div class="sc-contents main-desc">
				<h4 class="intro">ì±ì¥íë ë¹ì¦ëì¤ë¥¼ ìí</h4>
				<p><span class="highlight">ì¤ë§í¸ ì¹ì¬ì´í¸</span> íë«í¼ìëë¤.</p>
				<p>Lorem, ipsum dolor sit amet<br/> consectetur adipisicing elit.</p>
				<a href="#">MORE</a>
			</div>
		</div>
		<!-- <div class="swiper main-visual-slider">
			<div class="swiper-wrapper">
			<div class="swiper-slide">
				<div class="main-desc">
				<h4 class="intro">ì±ì¥íë ë¹ì¦ëì¤ë¥¼ ìí</h4>
				<p><span class="highlight">ì¤ë§í¸ ì¹ì¬ì´í¸</span> íë«í¼ìëë¤.</p>
				</div>
			</div>
			<div class="swiper-slide">
				<div class="main-desc">
				<h4 class="intro">ì±ì¥íë ë¹ì¦ëì¤ë¥¼ ìí</h4>
				<p><span class="highlight">ì¤ë§í¸ ì¹ì¬ì´í¸</span> íë«í¼ìëë¤.</p>
				</div>
			</div>
			<div class="swiper-slide">
				<div class="main-desc">
				<h4 class="intro">ì±ì¥íë ë¹ì¦ëì¤ë¥¼ ìí</h4>
				<p><span class="highlight">ì¤ë§í¸ ì¹ì¬ì´í¸</span> íë«í¼ìëë¤.</p>
				</div>
			</div>
			</div>
			<div class="swiper-pagination main-pagination"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div> -->
	</section>
	<section class="about-section">
		<h1 class="sc-tt">ì´ë°ì ì¹ì</h1>
		<div class="sc-inner about">
			<div class="sc-contents">
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="ì´ë°ì ì´ë¯¸ì§ ëì©" />
					</div>
					<div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo a veritatis dolores, omnis tenetur neque recusandae cumque ea voluptates harum ad facilis laborum sed asperiores corrupti similique debitis aperiam minima.</p>
					</div>
				</div>
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="ì´ë°ì ì´ë¯¸ì§ ëì©" />
					</div>
					<div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo a veritatis dolores, omnis tenetur neque recusandae cumque ea voluptates harum ad facilis laborum sed asperiores corrupti similique debitis aperiam minima.</p>
					</div>
				</div>
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="ì´ë°ì ì´ë¯¸ì§ ëì©" />
					</div>
					<div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo a veritatis dolores, omnis tenetur neque recusandae cumque ea voluptates harum ad facilis laborum sed asperiores corrupti similique debitis aperiam minima.</p>
					</div>
				</div>
			</div>
			<div class="about-link">
				<a href="#">MORE</a>
			</div>
		</div>
	</section>

	<section class="item-section">
		<h1 class="sc-tt">ìì´í ì¹ì</h1>
		<div class="sc-inner">
			<div class="sc-contents">
				<div class="border-box">
					<div class="swiper item-slider">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<div class="slide-contents">
									<div class="item-desc">
										<h4>Lorem01</h4>
										<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestiae sunt esse pariatur dicta expedita qui, est iusto. Reiciendis, perspiciatis ea! Distinctio, quo culpa? Laborum at quos aliquid rerum autem unde!</p>
									</div>
									<div class="item-img">
										<img src="/img/img.png" alt="ìì´í ì´ë¯¸ì§" />
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="slide-contents">
									<div class="item-desc">
										<h4>Lorem02</h4>
										<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestiae sunt esse pariatur dicta expedita qui, est iusto. Reiciendis, perspiciatis ea! Distinctio, quo culpa? Laborum at quos aliquid rerum autem unde!</p>
									</div>
									<div class="item-img">
										<img src="/img/img.png" alt="ìì´í ì´ë¯¸ì§" />
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="slide-contents">
									<div class="item-desc">
										<h4>Lorem03</h4>
										<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestiae sunt esse pariatur dicta expedita qui, est iusto. Reiciendis, perspiciatis ea! Distinctio, quo culpa? Laborum at quos aliquid rerum autem unde!</p>
									</div>
									<div class="item-img">
										<img src="/img/img.png" alt="ìì´í ì´ë¯¸ì§" />
									</div>
								</div>
							</div>
						</div>
						<div class="item-pagination"></div>
					</div>
					<div class="swiper-button-prev item-prev"></div>
					<div class="swiper-button-next item-next"></div>
					<!-- <div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestiae sunt esse pariatur dicta expedita qui, est iusto. Reiciendis, perspiciatis ea! Distinctio, quo culpa? Laborum at quos aliquid rerum autem unde!</p>
					</div>
					<div class="item-img">
						<img src="/img/img.png" alt="ìì´í ì´ë¯¸ì§" />
					</div> -->
				</div>
			</div>
			<!-- <div class="swiper-button-prev item-prev"></div>
			<div class="swiper-button-next item-next"></div> -->
		</div>
	</section>

	<section class="skills-section">
		<h1 class="sc-tt">ê¸°ë¥ ì¹ì</h1>
		<div class="sc-inner">
			<div class="sc-contents">
				<h3 class="skills-tt">Skills</h3>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="ê¸°ë¥ ì´ë¯¸ì§" />
					</div>
					<div class="skills-desc" data-aos="fade-right" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
				</div>
				<div class="skills">
					<div class="skills-desc skills-left" data-aos="fade-left" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="ê¸°ë¥ ì´ë¯¸ì§" />
					</div>
				</div>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="ê¸°ë¥ ì´ë¯¸ì§" />
					</div>
					<div class="skills-desc" data-aos="fade-right" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
				</div>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="ê¸°ë¥ ì´ë¯¸ì§" />
					</div>
					<div class="skills-desc" data-aos="fade-right" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
				</div>
				<div class="skills">
					<div class="skills-desc skills-left" data-aos="fade-left" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="ê¸°ë¥ ì´ë¯¸ì§" />
					</div>
				</div>
			</div>
		</div>
	</section>
</main>
<script src="/js/main02.js"></script>