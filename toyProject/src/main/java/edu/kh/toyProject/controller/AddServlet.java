package edu.kh.toyProject.controller;

import java.io.IOException;

import edu.kh.toyProject.dto.Student;
import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* 학생 추가 페이지에서 나타날 사항
 * 0. main.jsp에서 학생 추가 버튼 클릭시 (main.js 코드 확인)
 * 1. doGet 메서드에서는 add.jsp를 이용해서 추가할 화면 출력하기 (위임)
 * 2. doPost 메서드에서는 전달받은 정보를 이용해서 Student 객체 만들고 DB에 추가하기
 * 3. 추가 성공 시 메인페이지로, 실패 시 추가 화면(redirect -> get 방식)으로 
 */
@WebServlet("/student/add")
public class AddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String path = "/WEB-INF/views/add.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String stdName = req.getParameter("stdName");
			int age = Integer.parseInt(req.getParameter("age"));
			String gender = req.getParameter("gender");
			String score = req.getParameter("score");
			String studentComment = req.getParameter("studentComment");
			
			ToyProjectService service = new ToyProjectServiceImpl();
			int result = service.studentAdd(stdName, age, gender, score, studentComment);
			
			String url = null;
			String message = null;
			
			if(result > 0) {
				url = "/";
				message = "학생 " + stdName + " 이/가 추가되었습니다.";
			} else {
				url = "/student/add";
				message = "추가 실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
