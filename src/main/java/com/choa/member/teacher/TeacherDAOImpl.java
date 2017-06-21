package com.choa.member.teacher;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class TeacherDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "TeacherMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		TeacherDTO teacherDTO = (TeacherDTO)memberDTO;
		int result = sqlSession.insert(NAMESPACE+"joinMember",teacherDTO);
	
		if(result > 0){
			result = sqlSession.insert(NAMESPACE+"joinTeacher", teacherDTO);
		}
		
		return result;
	}

}
