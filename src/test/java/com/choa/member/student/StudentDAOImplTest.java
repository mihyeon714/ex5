package com.choa.member.student;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.controller.StudentController;
import com.choa.ex5.MyAbstractTestUnit;

public class StudentDAOImplTest extends MyAbstractTestUnit{
	
	
	@Autowired
	private StudentDAOImpl dao;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	
	private static StudentDTO studentDTO;
	
	
	@BeforeClass
	public static void makeStudent(){
		studentDTO = new StudentDTO();
		studentDTO.setId("myeon5");
		studentDTO.setName("면");
		studentDTO.setAge(25);
		studentDTO.setFileName("");
		studentDTO.setOriName("");
		studentDTO.setPhone("010-1111-2222");
		studentDTO.setGrade("s");
		studentDTO.setPw("0000");
		studentDTO.setSid("myeon5");
		studentDTO.setTid("IU");
	}
	

	//@Test
	public void test() throws Exception {
		
		//assertNotNull(dao);
		
		int result = dao.memberJoin(studentDTO);
		assertEquals(1, result);	
	}
	
	@Test
	public void testService() throws Exception{
		int result = studentServiceImpl.memberJoin(studentDTO);
		assertEquals(1, result);	
	}


}
