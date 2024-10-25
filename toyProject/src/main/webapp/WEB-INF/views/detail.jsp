<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${student.name}의 상세정보</title>
  <link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
  <h1> ${student.name}의 상세 정보</h1>
  
  <div>

	<div><strong>고유번호</strong> : ${student.studentNo}</div>
	<div><strong>이름</strong> : ${student.name}</div>
	<div><strong>나이</strong> : ${student.age}</div>
	<div><strong>성별</strong> : ${student.gender}</div>
	<div><strong>성적</strong> : ${student.score}</div>
	<c:if test="${not empty student.studentComment}">
	<div><strong>특이사항</strong> </div>
	<div class="studentComment">${student.studentComment}</div>
	</c:if>
	
  </div>

  
  <div class="btn-container">
	<div>
	  <button id="updateBtn">수정</button>
	  <button id="deleteBtn">삭제</button>
	</div>
	<br>
	<div>
	  <button id="goToListBtn">목록으로</button>
	</div>
  </div>
  
  <%-- session 에 message 가 있다면 --%>
  <c:if test="${not empty sessionScope.message}">
  <script>alert("${message}");</script>
  <c:remove var="message" scope="session" />
  </c:if>
  
  <script src="/resources/js/detail.js"></script>
</body>
</html>