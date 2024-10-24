package edu.kh.toyProject.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.toyProject.dto.Student;

public interface ToyProjectDAO {

	/** MainServlet 에서 학생 전체조회 DAO
	 * @param conn
	 * @return
	 */
	List<Student> studentListFullView(Connection conn) throws Exception;

	/** DetailServlet 에서 학생 상세조회 DAO
	 * @param conn
	 * @param studentNo
	 * @return
	 */
	Student studentDetailView(Connection conn, int studentNo) throws Exception;

}
