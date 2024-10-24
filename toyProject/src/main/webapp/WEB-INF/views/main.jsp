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
  
  <table id="studentList" border="1">
	<thead>
	  <tr>
		<th>학생 번호</th>
		<th>학생 이름</th>
	  </tr>
	</thead>

	<tbody>
	  <c:forEach items="${studentList}" varStatus="vs" var="std">
	  <tr>
		<th>${std.studentNo}</th>
		<th><a href="/student/detail?studentNo=${std.studentNo}">${std.name}</a></th>
	  </tr>
	  </c:forEach>
	</tbody>
  </table>

  <%-- session 범위에 message 가 있을 경우 --%>
  <c:if test="${not empty sessionScope.message}">
  <script>alert("${sessionScope.message}");</script>
  <c:remove var="message" scope="session"/>
  </c:if>
  
  <script src="/resources/js/main.js"></script>
</body>
</html>