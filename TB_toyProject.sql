-- 테이블 생성
CREATE TABLE TB_STUDENT(
	STD_NO NUMBER PRIMARY KEY,
	STD_NAME VARCHAR2(20) NOT NULL,
	STD_AGE NUMBER NOT NULL,
	STD_GENDER CHAR(1) CONSTRAINT GENDER_CHECK CHECK(STD_GENDER IN('M', 'F')),
	STD_SCORE CHAR(1) CONSTRAINT SCORE_CHECK CHECK(STD_SCORE IN('A', 'B', 'C', 'D', 'F')) 
);

DROP TABLE TB_STUDENT;	-- STD_GENDER조건 '남', '여'로 해서 크기 초과로 다시 만들었음
/*
-- 제약 조건 추가
ALTER TABLE TB_TODO
ADD CONSTRAINT TB_TODO_PK PRIMARY KEY(TODO_NO);

ALTER TABLE TB_TODO
MODIFY TODO_TITLE VARCHAR2(200) CONSTRAINT TODO_TITLE_NN NOT NULL;

ALTER TABLE TB_TODO
MODIFY TODO_DETAIL VARCHAR2(4000) CONSTRAINT TODO_DETAIL_NN NOT NULL;

ALTER TABLE TB_TODO
ADD CONSTRAINT TODO_COMPLETE_CHECK 
CHECK(TODO_COMPLETE IN (0, 1) );
*/

COMMENT ON COLUMN TB_STUDENT.STD_NO IS '학생 번호';
COMMENT ON COLUMN TB_STUDENT.STD_NAME IS '학생 이름';
COMMENT ON COLUMN TB_STUDENT.STD_AGE IS '학생 나이';
COMMENT ON COLUMN TB_STUDENT.STD_GENDER IS '학생 성별(M, F 제한)';
COMMENT ON COLUMN TB_STUDENT.STD_SCORE IS '학생 성적(A, B, C, D, F 제한)';

-- 시퀀스 생성
CREATE SEQUENCE SEQ_STUDENT_NO NOCACHE;

DROP SEQUENCE SEQ_STUDENT_NO;
-- 여기까지  수행 완료!!

-- 샘플 데이터 1개만 만들어보자
INSERT INTO TB_STUDENT
VALUES(SEQ_STUDENT_NO.NEXTVAL, '홍길동', 16, 'M', 'B');

SELECT * FROM TB_STUDENT;

COMMIT;


-- 샘플 데이터 2개 더 넣고 다시 조회해보자!
INSERT INTO TB_STUDENT
VALUES(SEQ_STUDENT_NO.NEXTVAL, '유관순', 16, 'F', 'A');

INSERT INTO TB_STUDENT
VALUES(SEQ_STUDENT_NO.NEXTVAL, '이순신', 17, 'M', 'C');

-- 이후 DQL, DML 문 수행 위주로!
SELECT STD_NO, STD_NAME, STD_AGE, STD_GENDER, STD_SCORE
FROM TB_STUDENT
ORDER BY 1 ASC;
/*
INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트2', '테스트2 입니다.', DEFAULT, DEFAULT);

INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트3', '테스트3 입니다.', DEFAULT, DEFAULT);

INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트4', '테스트4 입니다.', DEFAULT, DEFAULT);

COMMIT;
*/
SELECT STD_NO, STD_NAME, STD_AGE, STD_GENDER, STD_SCORE
FROM TB_STUDENT
WHERE STD_NO = 3;

