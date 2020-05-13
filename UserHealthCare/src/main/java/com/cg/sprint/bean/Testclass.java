package com.cg.sprint.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Testclass")
public class Testclass {
	@Id
	@Column(name="testid",length=10)
	private String testid;
	@Column(name="testname",length=25)
	private String testname;
	@Column(name="centrenum",length=10)
	private String centrenum;
	
	public Testclass() {}
	public Testclass(String testid, String testname, String centrenum) {
		
		this.testid = testid;
		this.testname = testname;
		this.centrenum = centrenum;
	}
	
public String getCentrenum() {
	return centrenum;
	}
public void setCentrenum(String centrenum) {
	this.centrenum = centrenum;
	}
public String getTestid() {
	return testid;
}
public void setTestid(String testid) {
	this.testid = testid;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}
}
