package edu.kh.toyProject.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.toyProject.common.JDBCTemplate.*;
import edu.kh.toyProject.dto.Student;

public class ToyProjectDAOImpl implements ToyProjectDAO{
	
	// 필드 : JDBC 객체 참조변수, Properties 참조변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	// 기본 생성자
	public ToyProjectDAOImpl() {
		try {
			String filePath = ToyProjectDAOImpl.class.getResource("/xml/sql.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외 발생");
			e.printStackTrace();
		}	
	}
	
	// 메서드
	@Override		// MainServlet 에서 학생 전체조회 DAO
	public List<Student> studentListFullView(Connection conn) throws Exception {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("studentListFullView");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student student = Student.builder()
									.studentNo(rs.getInt("STD_NO"))
									.name(rs.getString("STD_NAME"))
									.age(rs.getInt("STD_AGE"))
									.gender(rs.getString("STD_GENDER"))
									.score(rs.getString("STD_SCORE"))
									.build();
				
				studentList.add(student);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return studentList;
	}

	@Override		// DetailServlet 에서 학생 상세조회 DAO
	public Student studentDetailView(Connection conn, int studentNo) throws Exception {
		Student student = null;
		
		try {
			String sql = prop.getProperty("studentDetailView");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = Student.builder()
						.studentNo(rs.getInt("STD_NO"))
						.name(rs.getString("STD_NAME"))
						.age(rs.getInt("STD_AGE"))
						.gender(rs.getString("STD_GENDER"))
						.score(rs.getString("STD_SCORE"))
						.studentComment(rs.getString("STD_COMMENT"))
						.build();
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}

	@Override		// UpdateServlet 에서 학생 정보 수정 DAO
	public int studentUpdate(Connection conn, int studentNo, String name, int age, String score, String studentComment) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, score);
			pstmt.setString(4, studentComment);
			pstmt.setInt(5, studentNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override		// DeleteServlet 에서 학생 정보 삭제 DAO
	public int studentDelete(Connection conn, int studentNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentDelete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override		// AddServlet 에서 학생 추가(INSERT) DAO
	public int studentAdd(Connection conn, String stdName, int age, String gender, String score, String studentComment) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentAdd");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdName);
			pstmt.setInt(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, score);
			pstmt.setString(5, studentComment);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
