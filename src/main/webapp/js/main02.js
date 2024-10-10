
function hamburgerToggle(){
  let mbBtn = document.querySelector('.mb-nav');
  let nav = document.querySelector('nav');

  mbBtn.addEventListener('click', () => {
    mbBtn.classList.toggle('active');
    nav.classList.toggle('active');
  });
}

// 모바일, 태블릿 뎁스2 메뉴 보기
// function showNav(){
//   let navList = document.querySelectorAll('.nav-list');

//   navList.forEach((item) => {
//     let depth02 = item.querySelector('.depth02');

    
//   })
// }

function depth01Toggle(){
  let navLink = document.querySelectorAll('.nav-list > a');
  let navList = document.querySelectorAll('.nav-list');

  navLink.forEach((item) => {
    let depth01 = item.nextElementSibling;

    
    item.addEventListener('click', () => {
      document.querySelectorAll('.depth01').forEach((el) => {
        if(el !== depth01 && el.classList.contains('active')){
          el.classList.remove('active');
        }
      })
      depth01.classList.toggle('active');
    })
    // console.log(depth01);
  })

  
}

function depth02Toggle(){
  let depth01 = document.querySelectorAll('.depth01-list');

  depth01.forEach((item)=>{
    item.addEventListener('click', () => {
      let clickedDepth02 = item.querySelector('.depth02');

      document.querySelectorAll('.depth02').forEach((el) => {
        if (el !== clickedDepth02 && el.classList.contains('active')) {
          el.classList.remove('active');
        }
      })
      clickedDepth02.classList.toggle('active');
    }); 


  })
}

hamburgerToggle();
depth01Toggle();
depth02Toggle();