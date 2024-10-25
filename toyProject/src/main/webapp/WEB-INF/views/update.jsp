<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> ${student.name} 수정 페이지</title>
  <link rel="stylesheet" href="/resources/css/update.css">
</head>
<body>
  <h1>${student.name} 정보 수정</h1>
  
  <form action="/student/update" method="post" id="updateForm">
  	<fieldset class="detail-content"><legend>기본사항</legend>
	  <div>
		이름 : <input type="text" name="stdName" value="${student.name}" placeholder="이름을 입력하세요">
	  </div>
	  <div>
		나이 : <input type="number" name="age" value="${student.age}" placeholder="나이를 입력하세요">
	  </div>
	  <div class="score-div">
		<div>기존 성적 : ${student.score}</div>
		<div>바꿀 성적 :
		  <select name="score">
			<%-- 이렇게 작성해도 됨...? -> 됨....!!
			<option value="A" <c:if test="${std.stdScore == 'A'}">selected</c:if>>A</option>
			--%>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="D">D</option>
			<option value="F">F</option>
		  </select>
		</div>
	  </div>
  	</fieldset>
	<div>
	  <div><strong>특이사항</strong></div>
	  <textarea name="studentComment" rows="15" cols="100" style="resize: none;">${student.studentComment}</textarea>
	</div>
	<input type="hidden" name="studentNo" value="${param.studentNo}">
	
	<button>수정</button>
  </form>
  <br>
  <div>
	<button id="detailBtn">돌아가기</button>
  </div>

  <%-- 성적 수정 시 selected 옵션 추가하기 --%>
  <script>
  	const options = document.querySelectorAll("option");
  	
  	if("${student.score}" == "A") {
  		options[0].selected = true;
  	} else if("${student.score}" == "B"){
  		options[1].selected = true;
  	} else if("${student.score}" == "C"){
  		options[2].selected = true;
  	} else if("${student.score}" == "D"){
  		options[3].selected = true;
  	} else{
  		options[4].selected = true;
  	}
  </script>

  
  <%-- session 스코프에 message 있으면 alert 출력하기 --%>
  <c:if test="${not empty sessionScope.message}">
  <script>alert("${message}");</script>
  <c:remove var="message" scope="session" />
  </c:if>

  <script src="/resources/js/update.js"></script>
</body>
</html>