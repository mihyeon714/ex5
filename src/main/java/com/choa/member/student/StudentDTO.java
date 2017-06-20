package com.choa.member.student;

import com.choa.member.MemberDTO;

public class StudentDTO extends MemberDTO{
	private int sid;
	private String phone;
	private int tid;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
}
