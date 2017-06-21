package com.choa.member.teacher;

import java.sql.Date;

import com.choa.member.MemberDTO;

public class TeacherDTO extends MemberDTO{

	private String tid;
	private String subject;
	private Date hireDate;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
	
	
}
