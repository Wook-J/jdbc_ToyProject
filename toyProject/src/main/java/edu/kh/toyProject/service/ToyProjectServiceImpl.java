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

	@Override		// MainServlet 에서 학생 전체조회(SELECT) 서비스
	public List<Student> studentListFullView() throws Exception {
		Connection conn = getConnection();
		List<Student> studentList = dao.studentListFullView(conn);
		
		close(conn);
		
		return studentList;
	}

	@Override		// DetailServlet 에서 학생 상세조회(SELECT) 서비스
	public Student studentDetailView(int studentNo) throws Exception {
		Connection conn = getConnection();
		Student student = dao.studentDetailView(conn, studentNo);
		
		close(conn);
		
		return student;
	}

	@Override		// UpdateServlet 에서 학생 정보 수정(UPDATE) 서비스
	public int studentUpdate(int studentNo, String name, int age, String score, String studentComment) throws Exception {
		Connection conn = getConnection();
		int result = dao.studentUpdate(conn, studentNo, name, age, score, studentComment);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override		// DeleteServlet 에서 학생 정보 삭제(DELETE) 서비스
	public int studentDelete(int studentNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.studentDelete(conn, studentNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override		// AddServlet 에서 학생 추가(INSERT) 서비스
	public int studentAdd(String stdName, int age, String gender, String score, String studentComment) throws Exception {
		Connection conn = getConnection();
		int result = dao.studentAdd(conn, stdName, age, gender, score, studentComment);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}
