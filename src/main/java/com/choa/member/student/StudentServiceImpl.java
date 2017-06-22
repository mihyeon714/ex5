package com.choa.member.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.util.FileSaver;

@Service
@RequestMapping(value="/member/**")
public class StudentServiceImpl implements MemberService{
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;

	@Override
	public int memberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		System.out.println("memberDTO.f1.originFile= "+memberDTO.getF1().getOriginalFilename());
		
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/upload");
		String fileName = fs.filesave( realPath , memberDTO.getF1());
		
		memberDTO.setOriName(memberDTO.getF1().getOriginalFilename());
		memberDTO.setFileName(fileName);
		return studentDAOImpl.memberJoin(memberDTO);
	}

	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return studentDAOImpl.memberLogin(memberDTO);
	}
	/*
	@Override
	public MemberDTO memberPage(MemberDTO memberDTO) throws Exception{
		return studentDAOImpl.memberPage(memberDTO.getId());
	}
	*/


}
