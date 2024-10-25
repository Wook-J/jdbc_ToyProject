<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>학생추가 페이지</title>
  <link rel="stylesheet" href="/resources/css/add.css">
</head>

<body>
  <h1> 학생 추가 페이지입니다.</h1>
  
  <form action="/student/add" method="post" id="addForm">
	<div>
	  <span>이름</span> : &nbsp;
	  <input type="text" name="stdName" placeholder="이름을 입력해주세요">
	</div>
	<div>
	  <span>나이</span> : &nbsp;
	  <input type="number" name="age" placeholder="나이를 입력해주세요">
	</div>
	<div>
	  <span>성별</span> : &nbsp;
	  <label><input type="radio" name="gender" value="M" checked> 남 </label>
	  <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
	  <label><input type="radio" name="gender" value="F"> 여 </label>
	</div>
	<div>
	  <span>성적 </span> : &nbsp;
	  <select name="score">
		<option value="A">A</option>
		<option value="B">B</option>
		<option value="C">C</option>
		<option value="D">D</option>
		<option value="F">F</option>
	  </select>
	</div>
	<div>
	  <div>특이사항</div>
	  <textarea name="studentComment" rows="15" cols="100" style="resize: none;"></textarea>
	</div>

	<div>
	  <button>학생 추가</button>
	</div>
  </form>
  <br>
  <div>
	<button id="goToListBtn">목록으로</button>
  </div>  

  <script src="/resources/js/add.js"></script>
</body>
</html>