package com.choa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="memberPage", method=RequestMethod.GET)
	public void memberPage() throws Exception{}
	
	
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin(){}
	

	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void memberLogin(){}
	
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	@RequestMapping(value="studentJoin", method=RequestMethod.POST)
	public String memberJoin(StudentDTO studentDTO,Model model, HttpSession session) throws Exception{
		System.out.println("student");
		
		int result = studentServiceImpl.memberJoin(studentDTO, session);
		
		String message = "가입 실패";
		if(result>0){
			message = "가입 성공";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		return "commons/result";

	}
	

	@RequestMapping(value="studentLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		System.out.println("student");
		
		memberDTO = studentServiceImpl.memberLogin(memberDTO);
		String message = "로그인 실패";
		if(memberDTO != null){
			message = "로그인 성공";
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
	@RequestMapping(value="student/memberPage", method=RequestMethod.GET)
	public String memberPage(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		StudentDTO studentDTO = (StudentDTO) studentServiceImpl.memberPage(memberDTO);
		
		model.addAttribute("student", studentDTO);
		return "member/memberPage";
	}
	*/

	
	

}
