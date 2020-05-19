package com.cg.sprint.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Diagnostic_center")
public class Diagnostic_center {
	
	@Id	
    @Column(name="centreid",length=10)
	private String centreid;
	@Column(name="centrename",length=25)
	private String centrename; 
	@Column(name="centrePhno",length=10)  
	private long centrePhno;
	@Column(name="centreAdd",length=25)
	private String centreAdd;
	
	
	public Diagnostic_center() {}
	public Diagnostic_center(String centreid, String centrename, long centrePhno, String centreAdd) {
		
		this.centreid = centreid;
		this.centrename = centrename;
		this.centrePhno = centrePhno;
		this.centreAdd = centreAdd;
	}
	
	
	
	
	public String getCentreid() {
		return centreid;
	}
	public void setCentreid(String centreid) {
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
	
		
}
