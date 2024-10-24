// 목록으로 버튼 클릭 시, 메인페이지("/") 요청(GET 방식)
const goToListBtn = document.querySelector("#goToListBtn");
goToListBtn.addEventListener("click", () => {
  location.href = "/";
});