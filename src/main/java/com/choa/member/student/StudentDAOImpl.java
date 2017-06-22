package com.choa.member.student;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;


@Repository
public class StudentDAOImpl implements MemberDAO {	
	
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "StudentMapper.";
	private final String NAMESPACEMEM = "MemberMapper.";
	

	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		int result = sqlSession.insert(NAMESPACEMEM+"joinMember",memberDTO);
		
		if( result > 0 ){
			result = sqlSession.insert(NAMESPACE+"joinStudent",memberDTO);
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
	public StudentDTO memberPage(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberPage",id);
	}
	*/

}
