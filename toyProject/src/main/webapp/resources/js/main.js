// 학생 추가 버튼 클릭 시 "/student/add" url로 이동 (나중에)
const addStudentBtn = document.querySelector("#addStudentBtn");
addStudentBtn.addEventListener("click", ()=>{
  location.href = "/student/add";
});