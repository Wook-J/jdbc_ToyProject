package edu.kh.toyProject.controller;

import java.io.IOException;

import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* 학생 정보 삭제 (페이지 별도로 없음)
 * 0. detail.jsp에서 삭제 버튼 클릭시 (detail.js 코드 확인)
 * 1. url의 쿼리스트링(?studentNo=~~)에서 학생 정보 얻어올 수 있음
 * 2. 성공 시 메인페이지로, 실패 시 상세조회 화면으로
 * */
@WebServlet("/student/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int studentNo = Integer.parseInt(req.getParameter("studentNo"));
			ToyProjectService service = new ToyProjectServiceImpl();
			
			int result = service.studentDelete(studentNo);
			
			String url = null;
			String message = null;
			
			if(result > 0 ) {
				url = "/";
				message = "삭제성공";
			} else {
				url = "/student/detail?studentNo=" + studentNo;
				message = "삭제실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
