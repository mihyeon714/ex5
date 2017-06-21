package com.choa.member.student;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyAbstractTestUnit;

public class StudentDAOImplTest extends MyAbstractTestUnit{
	
	
	@Autowired(required=true)
	private StudentDAOImpl dao;
	
	private static StudentDTO studentDTO;
	
	
	@BeforeClass
	public static void makeStudent(){
		studentDTO = new StudentDTO();
		studentDTO.setId("myeon3");
		studentDTO.setName("면");
		studentDTO.setAge(25);
		studentDTO.setFileName("");
		studentDTO.setOriName("");
		studentDTO.setPhone("010-1111-2222");
		studentDTO.setGrade("s");
		studentDTO.setPw("0000");
		studentDTO.setSid("myeon3");
		studentDTO.setTid("IU");
	}
	

	@Test
	public void test() throws Exception {
		
		//assertNotNull(dao);
		
		int result = dao.memberJoin(studentDTO);
		assertEquals(1, result);
		
	}

}
