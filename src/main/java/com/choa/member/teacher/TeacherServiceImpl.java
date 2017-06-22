package com.choa.member.teacher;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.member.student.StudentDTO;
import com.choa.util.FileSaver;

@Service
public class TeacherServiceImpl implements MemberService {
	
	@Autowired
	private TeacherDAOImpl teacherDAOImpl;

	@Override
	public int memberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		String realPath = session.getServletContext().getRealPath("resources/upload");
		
		FileSaver fs = new FileSaver();
		String fileName = fs.filesave( realPath , memberDTO.getF1());
		
		memberDTO.setOriName(memberDTO.getF1().getOriginalFilename());
		memberDTO.setFileName(fileName);
		
		return teacherDAOImpl.memberJoin(memberDTO);
	}
	
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return teacherDAOImpl.memberLogin(memberDTO);
	}
	
	/*
	@Override
	public MemberDTO memberPage(MemberDTO memberDTO) throws Exception{
		return teacherDAOImpl.memberPage(memberDTO.getId());
	}
	*/
}
