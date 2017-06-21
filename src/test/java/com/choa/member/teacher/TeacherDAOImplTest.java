package com.choa.member.teacher;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyAbstractTestUnit;

public class TeacherDAOImplTest extends MyAbstractTestUnit {
	
	@Autowired
	private TeacherDAOImpl dao;
	private static TeacherDTO teacherDTO;
	
	@BeforeClass
	public static void makeTeacher(){
		teacherDTO = new TeacherDTO();
		teacherDTO.setId("IU2");
		teacherDTO.setName("아이유");
		teacherDTO.setAge(25);
		teacherDTO.setFileName("유이아파일");
		teacherDTO.setOriName("유이아파일");
		teacherDTO.setGrade("t");
		teacherDTO.setPw("0000");

		teacherDTO.setTid("IU2");
		teacherDTO.setSubject("MATH");
	}
	

	@Test
	public void test() throws Exception {
		//assertNotNull(dao);
		
		int result = dao.memberJoin(teacherDTO);
		assertEquals(1, result);
	}

}
