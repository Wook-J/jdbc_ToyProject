package edu.kh.toyProject.service;

import java.util.List;

import edu.kh.toyProject.dto.Student;

public interface ToyProjectService {

	/** MainServlet 에서 학생 전체조회(SELECT) 서비스
	 * @return
	 */
	List<Student> studentListFullView() throws Exception;

	/** DetailServlet 에서 학생 상세조회(SELECT) 서비스
	 * @param studentNo
	 * @return
	 */
	Student studentDetailView(int studentNo) throws Exception;

	/** UpdateServlet 에서 학생 정보 수정(UPDATE) 서비스
	 * @param studentNo
	 * @param name
	 * @param age
	 * @param score
	 * @return
	 */
	int studentUpdate(int studentNo, String name, int age, String score, String studentComment) throws Exception;

	/** DeleteServlet 에서 학생 정보 삭제(DELETE) 서비스
	 * @param studentNo
	 * @return
	 */
	int studentDelete(int studentNo) throws Exception;

	/** AddServlet 에서 학생 추가(INSERT) 서비스
	 * @param stdName
	 * @param age
	 * @param gender
	 * @param score
	 * @return
	 */
	int studentAdd(String stdName, int age, String gender, String score, String studentComment) throws Exception;

}
