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
	private final static String NAMESPACE="StudentMapper.";
	

	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		StudentDTO studentDTO = (StudentDTO)memberDTO;
		int result = sqlSession.insert(NAMESPACE+"joinMember",studentDTO);
		
		if( result > 0 ){
			result = sqlSession.insert(NAMESPACE+"joinStudent",studentDTO);
		}
		
		
		return result;
	}
	
	

}
