<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="/js/swiper.js"></script>
<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
<script>
	AOS.init();
	function checkAjax(data) {
		alert(data);

		$.ajax({
			url: '/',
			type: 'post',
			data: data,
			headers: {'Content-Type' : 'application/json; charset=UTF-8'},
			dataType: 'json',
			success: function(result) {

			}
		});
	}
</script>
<main>
	<section class="sc main-visual-section">
		<h1 class="sc-tt">메인 비주얼 섹션</h1>
		<div class="sc-inner visual">
			<div class="sc-contents main-desc">
				<h4 class="intro">성장하는 비즈니스를 위한</h4>
				<p><span class="highlight">스마트 웹사이트</span> 플랫폼입니다.</p>
				<p>Lorem, ipsum dolor sit amet<br/> consectetur adipisicing elit.</p>
				<a href="#">MORE</a>
			</div>
		</div>
	</section>
	<section class="about-section">
		<h1 class="sc-tt">어바웃 섹션</h1>
		<div class="sc-inner about">
			<div class="sc-contents">
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="어바웃 이미지 대용">
					</div>
					<div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo a veritatis dolores, omnis tenetur neque recusandae cumque ea voluptates harum ad facilis laborum sed asperiores corrupti similique debitis aperiam minima.</p>
					</div>
				</div>
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="어바웃 이미지 대용">
					</div>
					<div class="item-desc">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Illo a veritatis dolores, omnis tenetur neque recusandae cumque ea voluptates harum ad facilis laborum sed asperiores corrupti similique debitis aperiam minima.</p>
					</div>
				</div>
				<div class="about-service-item">
					<div class="item-img">
						<img src="/img/img.png" alt="어바웃 이미지 대용">
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
		<h1 class="sc-tt">아이템 섹션</h1>
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
										<img src="/img/img.png" alt="아이템 이미지">
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
										<img src="/img/img.png" alt="아이템 이미지">
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
										<img src="/img/img.png" alt="아이템 이미지">
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
						<img src="/img/img.png" alt="아이템 이미지">
					</div> -->
				</div>
			</div>
			<!-- <div class="swiper-button-prev item-prev"></div>
			<div class="swiper-button-next item-next"></div> -->
		</div>
	</section>

	<section class="skills-section">
		<h1 class="sc-tt">기능 섹션</h1>
		<div class="sc-inner">
			<div class="sc-contents">
				<h3 class="skills-tt">Skills</h3>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="기능 이미지">
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
						<img src="/img/img.png" alt="기능 이미지">
					</div>
				</div>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="기능 이미지">
					</div>
					<div class="skills-desc" data-aos="fade-right" data-aos-delay="200">
						<h4>Lorem</h4>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia soluta ratione pariatur! Dolores dolore exercitationem excepturi aut expedita animi non, blanditiis neque cumque itaque, quod libero, placeat perspiciatis labore reprehenderit.</p>
					</div>
				</div>
				<div class="skills">
					<div class="skills-img" data-aos="fade-up" data-aos-delay="50">
						<img src="/img/img.png" alt="기능 이미지">
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
						<img src="/img/img.png" alt="기능 이미지">
					</div>
				</div>
			</div>
		</div>
	</section>
</main>
<script src="/js/main02.js"></script>