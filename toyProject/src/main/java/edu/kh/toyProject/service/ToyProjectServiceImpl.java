package edu.kh.toyProject.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.toyProject.common.JDBCTemplate.*;
import edu.kh.toyProject.dao.ToyProjectDAO;
import edu.kh.toyProject.dao.ToyProjectDAOImpl;
import edu.kh.toyProject.dto.Student;

public class ToyProjectServiceImpl implements ToyProjectService{
	
	// 필드
	private ToyProjectDAO dao = new ToyProjectDAOImpl();

	@Override		// MainServlet 에서 학생 전체조회 서비스
	public List<Student> studentListFullView() throws Exception {
		Connection conn = getConnection();
		List<Student> studentList = dao.studentListFullView(conn);
		
		close(conn);
		
		return studentList;
	}

	@Override		// DetailServlet 에서 학생 상세조회 서비스
	public Student studentDetailView(int studentNo) throws Exception {
		Connection conn = getConnection();
		Student student = dao.studentDetailView(conn, studentNo);
		
		close(conn);
		
		return student;
	}

}
