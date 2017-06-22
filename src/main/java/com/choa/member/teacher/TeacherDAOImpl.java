package com.choa.member.teacher;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;

@Repository
public class TeacherDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "TeacherMapper.";
	private final String NAMESPACEMEM = "MemberMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {

		int result = sqlSession.insert(NAMESPACEMEM+"joinMember",memberDTO);
	
		if(result > 0){
			result = sqlSession.insert(NAMESPACE+"joinTeacher", memberDTO);
		}
		
		return result;
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		//return sqlSession.selectOne(NAMESPACEMEM+"loginMember",memberDTO);	
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	/*
	@Override
	public TeacherDTO memberPage(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberPage",id);
	}
	*/
}
