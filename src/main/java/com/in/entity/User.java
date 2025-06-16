package com.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Tab")
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer uId;
	
	@Column(name="NAME")
	private String uname;
	
	@Column(name="ADDR")
	private String addr;
	
	public User(Integer uId, String uname, String addr) {
		super();
		this.uId = uId;
		this.uname = uname;
		this.addr = addr;
	}
	public User() {
		super();
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uname=" + uname + ", addr=" + addr + "]";
	}
	
	
}
