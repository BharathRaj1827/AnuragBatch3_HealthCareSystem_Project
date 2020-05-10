package com.cg.sprint.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Testclass")
public class Testclass {
	@Id
	@Column(name="testid")
	private int testid;
	@Column(name="testname")
	private String testname;
	@Column(name="centrenum")
	private int centrenum;
	
	public Testclass() {}
	public Testclass(int testid, String testname, int centrenum) {
		
		this.testid = testid;
		this.testname = testname;
		this.centrenum = centrenum;
	}
	
public int getCentrenum() {
	return centrenum;
	}
public void setCentrenum(int centrenum) {
	this.centrenum = centrenum;
	}
public int getTestid() {
	return testid;
}
public void setTestid(int testid) {
	this.testid = testid;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}
}
