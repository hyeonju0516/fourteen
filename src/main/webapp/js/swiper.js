const swiper = new Swiper('.item-slider', {
  direction: 'horizontal',
  loop: false,
  // effect : 'fade',
  loopAdditionalSlides : 1,
  slidesPerView: 1,
  loopedSlides: 1,
  slidesPerGroup: 1,

  // If we need pagination
  pagination: {
    el: '.item-pagination',
  },

  // Navigation arrows
  navigation: {
    nextEl: '.item-next',
    prevEl: '.item-prev',
  },
});