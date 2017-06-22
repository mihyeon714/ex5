package com.choa.ex5;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.util.FileSaver;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="/test/fileUpForm")
	public void fileUp(){}
	
	
	//1번째 방법 : MultipartHttpServletRequest 로 받기
	// @RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request) throws Exception{
		//파일 정보만 가지고 있고 저장은 안된 상태
		
		MultipartFile multipartFile = request.getFile("f1"); //객체로 담아서 꺼내자
		
		System.out.println("NAME = "+name);
		System.out.println("getName = "+multipartFile.getName()); //파라미터이름
		System.out.println("getOriginalFilename = "+multipartFile.getOriginalFilename()); //올렸을때 이름
		System.out.println("getSize = "+multipartFile.getSize());
		
		String path = request.getSession().getServletContext().getRealPath("resources/upload"); // resources/upload까지의 경로
		
		FileSaver fs = new FileSaver();
		fs.filesave(path, multipartFile.getOriginalFilename(), multipartFile.getBytes());
	}
	
	
	//2번째 방법 : 파라미터이름을 맞춰서 MultipartFile 로 받아오기 (Spring이 이름 같으면 알아서 넣어줌)
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload2(String name, MultipartFile f1 , HttpSession session) throws Exception{ //파라미터이름과 동일하게
		System.out.println("NAME = "+name);
		System.out.println("getName = "+f1.getName()); //파라미터이름
		System.out.println("getOriginalFilename = "+f1.getOriginalFilename()); //올렸을때 이름
		System.out.println("getSize = "+f1.getSize());
		
		String path = session.getServletContext().getRealPath("resources/upload");
	
		FileSaver fs = new FileSaver();
		fs.filesave(path, f1.getOriginalFilename(), f1.getBytes());
	}
	
	
	//3번째 방법 : DTO 로 받기 //파라미터 받는 방법과 동일하다고 볼 수 있다
	@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload3(FileDTO fileDTO, HttpSession session) throws Exception{ 
		
		System.out.println("NAME = "+fileDTO.getName());
		System.out.println("getName = "+fileDTO.getF1().getName()); //파라미터이름
		System.out.println("getOriginalFilename = "+fileDTO.getF1().getOriginalFilename()); //올렸을때 이름
		System.out.println("getSize = "+fileDTO.getF1().getSize());
		
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/upload");
	
		fs.filesave(realPath, fileDTO.getF1());
		
		
	}
	
	
	
	

	
	/*
	FileSaver 객체에 멤버 함수로 만듬
	//파일을 디스크에 저장
	private String upload1(MultipartFile f,String path) throws Exception{//파일정보//실제저장경로 
		System.out.println("경로 : "+path);
		//똑같은 이름의 파일이 있을때는 어쩔래요 
		//예전에는 정책이 있었는디...
		//랜덤한 이름을 만들어주는 클래스를 사용하겠다
		String fileName = UUID.randomUUID().toString(); //이 이름을 저장할게요
		System.out.println("랜덤하게 만들어준 fileName = "+fileName);
		fileName = fileName +"_"+ f.getOriginalFilename();
		System.out.println("랜덤하게 만들어준 fileName_실제이름 = "+fileName);
		File file = new File(path, fileName); //경로와 파일명
		
		//저장해봅시다
		//spring에서 제공해주는 file저장 객체
		FileCopyUtils.copy(f.getBytes(), file); //읽어들이는 곳 //보내는 곳 //f.getBytes() 자체를 보내는애이름으로 저장하겠다
		
		
		return fileName;
	}
	*/
	
}
