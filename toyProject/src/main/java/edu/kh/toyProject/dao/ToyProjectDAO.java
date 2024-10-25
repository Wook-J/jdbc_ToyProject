package edu.kh.toyProject.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.toyProject.dto.Student;

public interface ToyProjectDAO {

	/** MainServlet 에서 학생 전체조회(SELECT) DAO
	 * @param conn
	 * @return
	 */
	List<Student> studentListFullView(Connection conn) throws Exception;

	/** DetailServlet 에서 학생 상세조회(SELECT) DAO
	 * @param conn
	 * @param studentNo
	 * @return
	 */
	Student studentDetailView(Connection conn, int studentNo) throws Exception;

	/** UpdateServlet 에서 학생 정보 수정(UPDATE) DAO
	 * @param conn
	 * @param studentNo
	 * @param name
	 * @param age
	 * @param score
	 * @return
	 */
	int studentUpdate(Connection conn, int studentNo, String name, int age, String score, String studentComment) throws Exception;

	/** DeleteServlet 에서 학생 정보 삭제(DELETE) DAO
	 * @param conn
	 * @param studentNo
	 * @return
	 */
	int studentDelete(Connection conn, int studentNo) throws Exception;

	/** AddServlet 에서 학생 추가(INSERT) DAO
	 * @param conn
	 * @param stdName
	 * @param age
	 * @param gender
	 * @param score
	 * @return
	 */
	int studentAdd(Connection conn, String stdName, int age, String gender, String score, String studentComment) throws Exception;

}
