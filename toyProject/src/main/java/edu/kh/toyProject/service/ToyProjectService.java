package edu.kh.toyProject.service;

import java.util.List;

import edu.kh.toyProject.dto.Student;

public interface ToyProjectService {

	/** MainServlet 에서 학생 전체조회 서비스
	 * @return
	 */
	List<Student> studentListFullView() throws Exception;

	/** DetailServlet 에서 학생 상세조회 서비스
	 * @param studentNo
	 * @return
	 */
	Student studentDetailView(int studentNo) throws Exception;

}
