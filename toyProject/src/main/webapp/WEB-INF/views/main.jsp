<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>학생조회 메인 페이지</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1>학생 조회 메인 페이지</h1>
  
  <h3>
	학생 수 : 총 ${fn:length(studentList)} 명 / 
	남 : ${numMale}명, 여: ${fn:length(studentList) - numMale}명
  </h3>
  
  <div>
	<div id="scoresTitle">성적분포</div>
	<table id="scoresTable">
	  <tr>
		<th>학점</th>
		<th>A</th>
		<th>B</th>
		<th>C</th>
		<th>D</th>
		<th>F</th>
	  </tr>
	  <tr>
		<th>학생 수</th>
		<td>${numScoreA}</td>
		<td>${numScoreB}</td>
		<td>${numScoreC}</td>
		<td>${numScoreD}</td>
		<td>${numScoreF}</td>
	  </tr>
	</table>
  </div>

  
  <table id="studentList" border="1">
	<thead>
	  <tr>
		<th>학생 이름</th>
		<th>나이</th>
		<th>성별</th>
		<th>성적</th>
	  </tr>
	</thead>
	<tbody>
	  <c:forEach items="${studentList}" varStatus="vs" var="std">
	  <tr>
		<th><a href="/student/detail?studentNo=${std.studentNo}">${std.name}</a></th>
		<th>${std.age}</th>
		<th>
		  <c:if test="${std.gender == 'M'}">남</c:if>
		  <c:if test="${std.gender == 'F'}">여</c:if>
		</th>
		<th>${std.score}</th>
	  </tr>
	  </c:forEach>
	</tbody>
  </table>
  
  <br>
  
  <div>
	<button id="addStudentBtn">학생 추가</button>
  </div>

  <%-- session 범위에 message 가 있을 경우 --%>
  <c:if test="${not empty sessionScope.message}">
  <script>alert("${sessionScope.message}");</script>
  <c:remove var="message" scope="session"/>
  </c:if>
  
  <script src="/resources/js/main.js"></script>
</body>
</html>