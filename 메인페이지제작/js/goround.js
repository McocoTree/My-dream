// 콜백 함수 (onLoad call back func)
function call_js(){
  //UI객체참조변수 선언
  let slideshow = document.querySelector(".slideshow");
  let slideshow_slides = document.querySelector(".slideshow_slides");
  //<a href="#"><img></a> UI 객체배열
  let slides = document.querySelectorAll(".slideshow_slides a");
  let prev = document.querySelector(".prev");
  let next = document.querySelector(".next");
  let indicators = document.querySelectorAll(".indicator a");
  //회전목마의 현재 위치 값, 시간설정 , 슬라이드 갯수
  let currentIndex = 0; 
  let timer = null;
  let slideCount = slides.length ; 

  //회전목마 이미지를 우측으로 배치
  for (let i=0;i<slideCount;i++){
    let newLeft = `${i*100}%`;    // i * 100 + `%`; 같은의미임 
    slides[i].style.left = newLeft;
  }

  //회전목마를 움직인다. () slideshow_slides 왼쪽으로 -100%씩 이동
  function gotoSlide(index) {
    currentIndex = index;
    let newLeft = index*-100+'%';
    slideshow_slides.style.left = newLeft;
    indicators.forEach((e)=>{
      e.classList.remove("active");
    });
    indicators[currentIndex].classList.add("active");
  
}
//0번 ~ 3번까지 3초씩 돌려
  gotoSlide(0);
// 3초간 
function startTimer(){
  timer = setInterval(function(){
    currentIndex += 1;
    let Index = currentIndex  % slideCount;
    gotoSlide(Index);
  }, 3000)
}
startTimer(); 

//이벤트 처리
slideshow_slides.addEventListener('mouseenter',()=>{
  clearInterval(timer);
});
slideshow_slides.addEventListener('mouseleave',function(){
  startTimer(); 
});
prev.addEventListener('mouseenter',()=>{
  clearInterval(timer);
});
next.addEventListener('mouseenter',()=>{
  clearInterval(timer);
});
prev.addEventListener("click",function(e){
  e.preventDefault()  //a tag 기본기능 막기
  currentIndex -= 1;
  if(currentIndex <0){
  currentIndex = slideCount -1;
}
gotoSlide(currentIndex) ;
});

next.addEventListener("click",function(e){
  e.preventDefault()  //a tag 기본기능 막기
  currentIndex -= 1;
  if(currentIndex <0){
  currentIndex = slideCount -1;
}
gotoSlide(currentIndex) ;
});
//indicator click 해당화면으로이동
indicators.forEach((e)=>{
  e.addEventListener('mouseenter',()=>{
    clearInterval(timer);
  });
}); 

for(let i=0; i<indicators.length; i++){
  indicators[i].addEventListener('click',(e)=>{
    e.preventDefault(); 
    gotoSlide(i);
  });
}
}