const stdName = document.querySelector("[name=stdName]");
const age = document.querySelector("[name=age]");


const addForm = document.querySelector("#addForm");
addForm.addEventListener("submit", (e)=>{
  const inputName = stdName.value.trim();
  // console.log(inputName);
  // e.preventDefault();

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
    age.value = "";
    return;
  }
  if(Math.floor(inputAge) != inputAge){
    e.preventDefault();
    alert("자연수를 입력해주세요");
    age.focus();
    age.value = "";
  }
});

const goToListBtn = document.querySelector("#goToListBtn");
goToListBtn.addEventListener("click", () => {
  location.href = "/";
});