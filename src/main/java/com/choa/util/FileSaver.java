package com.choa.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileSaver {
	
	//저장한 파일NAME
	public String filesave(String realPath, String oriName , byte [] fileData) throws Exception{
		
		File f = new File(realPath);
		//폴더가 안만들어져있을 경우
		if(!f.exists()){
			f.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString()+"_"+oriName; // upload(만들어준)폴더에 저장되는 실제 파일이름 >DB저장
		File target = new File(f,fileName);
		FileCopyUtils.copy(fileData, target); //데이터 저장방법1
		return fileName;
	}
}
