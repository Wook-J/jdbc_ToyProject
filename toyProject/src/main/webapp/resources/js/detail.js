// 목록으로 버튼 클릭 시, 메인페이지("/") 요청(GET 방식)
const goToListBtn = document.querySelector("#goToListBtn");
goToListBtn.addEventListener("click", () => {
  location.href = "/";
});

// 학생정보 삭제 또는 수정하는 경우 서블릿에 담을 정보
const studentNo = new URLSearchParams(location.search).get("studentNo");

// 수정버튼 클릭 시
const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click", () => {
  location.href = "/student/update?studentNo=" + studentNo;
});