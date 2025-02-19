package edu.kh.toyProject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.toyProject.dto.Student;
import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* main페이지에서 나타날 사항
 * 1. 등록되어 있는 모든 학생 목록(List형태 만들어서 Service 단에 넘기기)
 * 2. 학생 목록에서 이름 클릭 시 학생 상세조회 화면 이동(main.jsp에서 DetailServlet으로 이동)
 * 3. 학생 추가 버튼(main.jsp에서 AddStudentSerlvet으로 이동)
 * */
@WebServlet("/main")	
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ToyProjectService service = new ToyProjectServiceImpl();
			
			List<Student> studentList = service.studentListFullView();
			int numMale = 0;
			int numScoreA = 0;
			int numScoreB = 0;
			int numScoreC = 0;
			int numScoreD = 0;
			int numScoreF = 0;
			
			for(Student std : studentList) {
				if(std.getGender().equals("M")) numMale++;
				
				if(std.getScore().equals("A")) numScoreA++;
				else if(std.getScore().equals("B")) numScoreB++;
				else if(std.getScore().equals("C")) numScoreC++;
				else if(std.getScore().equals("D")) numScoreD++;
				else numScoreF++;
			}
			
			req.setAttribute("studentList", studentList);
			req.setAttribute("numMale", numMale);
			req.setAttribute("numScoreA", numScoreA);
			req.setAttribute("numScoreB", numScoreB);
			req.setAttribute("numScoreC", numScoreC);
			req.setAttribute("numScoreD", numScoreD);
			req.setAttribute("numScoreF", numScoreF);
			
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
