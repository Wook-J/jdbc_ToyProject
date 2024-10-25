package edu.kh.toyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	
	private int studentNo;			// STD_NO
	private String name;			// STD_NAME
	private int age;				// STD_AGE
	private String gender;			// STD_GENDER
	private String score;			// STD_SCORE
	private String studentComment;	// STD_COMMENT

}
