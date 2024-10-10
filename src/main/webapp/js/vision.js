let slideIndex = 0;
showSlides();

function showSlides() {
    let slides = document.getElementsByClassName("slide");
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    slides[slideIndex-1].style.display = "block";
    setTimeout(showSlides, 2000); // 이미지 변경 시간 (2초)
}

// 이미지 클릭 시 설명 변경
let images = document.querySelectorAll(".slide img");
let description = document.querySelector(".description p");

images.forEach((img, index) => {
    img.addEventListener("click", () => {
        let descriptions = ["설명 1", "설명 2", /* 추가 설명 */];
        description.textContent = descriptions[index];
    });
});
