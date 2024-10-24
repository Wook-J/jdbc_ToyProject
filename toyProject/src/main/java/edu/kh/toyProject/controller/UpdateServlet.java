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

/* 학생 추가페이지에서 나타날 사항
 * 1. 이름/나이/성별/성적 입력 할 수 있는 태그 작성
 * 2. 추가 성공 시 메인페이지로, 실패 시 추가 화면으로
 * */
@WebServlet("/student/update")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int studentNo = Integer.parseInt(req.getParameter("studentNo"));
			ToyProjectService service = new ToyProjectServiceImpl();
			
			Student student = service.studentDetailView(studentNo);
			
			if(student == null) {			// studentNo에 현재 저장되지 않은 값을 강제 대입 시
				resp.sendRedirect("/");
				return;
			}
			
			req.setAttribute("student", student);
			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
