const studentNo = new URLSearchParams(location.search).get("studentNo");

const stdName = document.querySelector("[name=stdName]");
const age = document.querySelector("[name=age]");

// 수정할 때 제한조건(이름 공백 또는 나이 자연수 아닐 경우) 걸기
const updateForm = document.querySelector("#updateForm");
updateForm.addEventListener("submit", (e)=>{

  const inputName = stdName.value.trim();
  if(inputName.length === 0){
    e.preventDefault();
    alert("학생이름을 입력해 주세요");
    stdName.focus();
    stdName.value = "";
    return;
  }

  const inputAge = age.value;
  if(inputAge <= 0){
    e.preventDefault();
    alert("양수를 입력해주세요");
    age.focus();
    return;
  }
  if(Math.floor(inputAge) != inputAge){
    e.preventDefault();
    alert("자연수를 입력해주세요");
    age.focus();
    return;
  }
});

// 원래 학생 상세조회 페이지로 돌아가기
const detailBtn = document.querySelector("#detailBtn");
detailBtn.addEventListener("click", ()=>{
  location.href = "/student/detail?studentNo=" + studentNo;
});