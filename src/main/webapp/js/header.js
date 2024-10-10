// header event
let mbNav = document.querySelector('.mb-nav');




// window size >= 1024 responsive
if(window.innerWidth >= 1024){
  let navList = document.querySelectorAll('.nav-list');

  navList.forEach(function(navList){
    let depth02 = navList.querySelector('.depth02');
    let navBg = document.querySelector('.nav-bg');
    let depth02List = navList.querySelectorAll('.depth02-list');


    // nav-list mouse event (nav depth02 show || hide)
    navList.addEventListener('mouseover', function(){
      depth02.classList.add('active');
      navBg.classList.add('on');
    });
    navList.addEventListener('mouseleave', function(){
      depth02.classList.remove('active');
      // all depth03 menu hide
      navList.querySelectorAll('.depth03').forEach(function(depth03){
        depth03.classList.remove('active');
      });
      navBg.classList.remove('on');
    });

    // nav depth03 click toggle
    depth02List.forEach(function(depth02){
      let depth03 = depth02.querySelector('.depth03');

      depth02.addEventListener('click', function(){
        depth02List.forEach(function(item){
          if (item !== depth02) {
            item.querySelector('.depth03').classList.remove('active');
          }
        });
        depth03.classList.toggle('active');
      });

    });
    
    
    
  })
}
// window width < 1024 responsive
else if(window.innerWidth < 1024){
  
  let navList = document.querySelectorAll('.nav-list');
  

  // hamburger menu animation
  mbNav.addEventListener('click', function(){
    // if(mbNav.classList.contains('closed')){
    //   mbNav.classList.remove('closed');
    // }
    mbNav.classList.toggle('closed');
  });

  // tablet, mobile nav depth02 show || hide
  // navList.forEach(function(navItem){
  //   let navLink = navItem.querySelector('a');
  //   let depth02 = navItem.querySelector('.depth02');

  //   navLink.addEventListener('click', function(){
  //     depth02.classList.toggle('show');
  //   });

  // });

  // navLink.addEventListener('click', function(){
  //   let depth02 = navList.querySelector('.depth02');
  //   depth02.classList.toggle('show');
  // });
  
  // navList.forEach(function(navList){
  //   let depth02 = navList.querySelector('.depth02');
  //   let depth03 = depth02.querySelector('.depth03');
    

    
  //   // navList.addEventListener('click', function(){
  //   //   if(depth02.classList.contains('show')){
  //   //     depth02.classList.remove('show');  
  //   //   }else depth02.classList.add('show');
      

      
  //   // });
  //   // depth02.addEventListener('click', function(){
  //   //   depth03.classList.toggle('show');
  //   // });
  // });

}

function init() {
  handleResponsiveBehavior(); // 페이지 로드 시 동작 설정
  window.addEventListener('resize', handleResponsiveBehavior); // 창 크기가 변경될 때마다 동작 설정
}

init();

