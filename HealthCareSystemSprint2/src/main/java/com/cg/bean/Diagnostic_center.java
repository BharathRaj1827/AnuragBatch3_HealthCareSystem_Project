package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="Diagnostic_center")
public class Diagnostic_center {
	
	@Id
	private int centreid;
	public int getCentreid() {
		return centreid;
	}
	public void setCentreid(int centreid) {
		this.centreid = centreid;
	}
	public String getCentrename() {
		return centrename;
	}
	public void setCentrename(String centrename) {
		this.centrename = centrename;
	}
	public long getCentrePhno() {
		return centrePhno;
	}
	public void setCentrePhno(long centrePhno) {
		this.centrePhno = centrePhno;
	}
	public String getCentreAdd() {
		return centreAdd;
	}
	public void setCentreAdd(String centreAdd) {
		this.centreAdd = centreAdd;
	}
	private String centrename;
	private long centrePhno;
	private String centreAdd;
	
	@OneToMany(/*mappedBy="diagnostic_center",*/cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="centreid",referencedColumnName="centreid")
	private List<Test> test= new ArrayList<Test>();
	
	
	/*
	@OneToMany(mappedBy="diagnostic_center", cascade=CascadeType.ALL)
	private List<Appointment> appointment= new ArrayList<Appointment>();
	*/
	
	public List<Test> getTest() {
		return test;
	}
	public void setTest(List<Test> test) {
		this.test = test;
	}
		
}
