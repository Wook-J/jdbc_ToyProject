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
import jakarta.servlet.http.HttpSession;

/* 학생 상세 조회 페이지에서 나타날 사항
 * 1. 선택된 학생에 대한 상세 정보 출력(이름/나이/성별/성적)
 *   쿼리스트링(?studentNo=~~) 부분에서 얻어온 값을 기준으로 서비스호출해서 객체 가져오기
 * 2. 목록으로 버튼(location.href="/")
 * 3. 수정 버튼 (클릭 시 수정 화면으로 이동)
 * 4. 삭제 버튼 (성공 시 메인페이지로, 실패 시 상세조회 화면으로)
 * */
@WebServlet("/student/detail")
public class DetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int studentNo = Integer.parseInt(req.getParameter("studentNo"));
			ToyProjectService service = new ToyProjectServiceImpl();
			
			Student student = service.studentDetailView(studentNo);
			
			// studentNo에 해당하는 student 없는 경우 처리
			if(student == null) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "해당 번호(" + studentNo + ")에 학생이 존재히지 않습니다.");	
				resp.sendRedirect("/");
				return;
			}
			
			// studentNo에 해당하는 student 있는 경우 처리
			req.setAttribute("student", student);
			String path = "/WEB-INF/views/detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
