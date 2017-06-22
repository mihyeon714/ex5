package com.choa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class TeacherController {
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;


	
	@RequestMapping(value="teacherJoin" , method=RequestMethod.POST)
	public String memberJoin(TeacherDTO teacherDTO, Model model, HttpSession session) throws Exception{
		System.out.println("teacher");
		int result = teacherServiceImpl.memberJoin(teacherDTO, session);
		
		String message = "가입 실패";
		if(result>0){
			message = "가입 성공";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		return "commons/result";
	}

	@RequestMapping(value="teacherLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		System.out.println("teacher");
		
		memberDTO = teacherServiceImpl.memberLogin(memberDTO);
		
		String message = "선생님 로그인 실패";
		if(memberDTO != null){
			message = "선생님 로그인 성공";
			session.setAttribute("member", memberDTO);
			System.out.println("로그인 한 id = "+memberDTO.getId());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("path", "../");
		mv.addObject("message",message);
		mv.setViewName("commons/result");

		return mv;

	}
	
	
	/*
	@RequestMapping(value="teacher/memberPage", method=RequestMethod.GET)
	public String memberPage(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		TeacherDTO teacherDTO = (TeacherDTO) teacherServiceImpl.memberPage(memberDTO);
		
		model.addAttribute("teacher", teacherDTO);
		return "member/memberPage";
	}
	*/
	
	
	

}
