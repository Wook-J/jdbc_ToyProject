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
	<div>
	  이름 : <input type="text" name="stdName" value="${student.name}">
	</div>
	<div>
	  나이 : <input type="number" name="age" value="${student.age}">
	</div>
	<div>
	  기존 성적 : ${student.score} <br>
	  바꿀 성적 :
	  <select name="score">
		<option value="A" checked>A</option>
		<option value="B">B</option>
		<option value="C">C</option>
		<option value="D">D</option>
		<option value="F">F</option>
	  </select>
	</div>
	<div>
	  <div>특이사항</div>
<%--  <textarea rows="" cols=""></textarea>
--%>
	  <textarea name="studentComment" rows="15" cols="100" style="resize: none;">${student.studentComment}</textarea>
	</div>
	<input type="hidden" name="studentNo" value="${param.studentNo}">
	
	<button>수정</button>
  </form>
  <br>
  <div>
	<button id="detailBtn">돌아가기</button>
  </div>
  
  <%-- session 스코프에 message 있으면 alert 출력하기 --%>
  <c:if test="${not empty sessionScope.message}">
  <script>alert("${message}");</script>
  <c:remove var="message" scope="session" />
  </c:if>

  <script src="/resources/js/update.js"></script>
</body>
</html>