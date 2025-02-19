<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${student.name} 의 상세정보</title>
  <link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
  <h1> ${student.name} 의 상세 정보</h1>
  
  <fieldset class="detail-content">
	<legend>기본사항</legend>
	<div><strong>고유번호</strong> : ${student.studentNo}</div>
	<div><strong>이름</strong> : ${student.name}</div>
	<div><strong>나이</strong> : ${student.age}</div>
	<div>
	  <strong>성별</strong> : 
	  <c:if test="${student.gender == 'M'}">남성 (${student.gender})</c:if>
	  <c:if test="${student.gender == 'F'}">여성 (${student.gender})</c:if>

	</div>
	<div><strong>성적</strong> : ${student.score}</div>	
  </fieldset>

  <c:if test="${not empty student.studentComment}">
  <br>
  <div>  
	<div><strong>특이사항</strong> </div>
	<div class="studentComment">${student.studentComment}</div>
  </div>
  </c:if>

  
  <div class="btn-container">
	<div>
	  <button id="updateBtn">수정</button>
	  <button id="deleteBtn">삭제</button>
	</div>
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