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
						.build();
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}

}
