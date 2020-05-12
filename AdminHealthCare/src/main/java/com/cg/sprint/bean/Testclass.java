package com.cg.sprint.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Testclass")
public class Testclass {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name="testid",nullable=false,updatable=false)
	private String testid;
	@Column(name="testname")
	private String testname;
	@Column(name="centrenum")
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
