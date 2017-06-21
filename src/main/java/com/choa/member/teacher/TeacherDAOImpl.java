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

}
