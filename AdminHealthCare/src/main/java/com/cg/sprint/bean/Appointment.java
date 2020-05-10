package com.cg.sprint.bean;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Appointment")

public class Appointment {
	@Id
	@Column(name="appointmentid")
	private int appointmentid;	
	@Column(name="appointmentstatus")
	private String appointmentstatus;
	@Column(name="datetime")
	private SimpleDateFormat datetime;
	@Column(name="centrenumber")
	private int centrenumber;
	@Column(name="testnames")
	private String testnames;
	
	public Appointment() {}
	public Appointment(int appointmentid, String appointmentstatus, SimpleDateFormat datetime, int centrenumber, String testnames) {
		
		this.appointmentid = appointmentid;
		this.appointmentstatus = appointmentstatus;
		this.datetime = datetime;
		this.centrenumber = centrenumber;
		this.testnames = testnames;
	}
	
	
	//@Column(name="usersid")
	//private int usersid;
	
	
	/*
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="appointmentid")
	private Users users;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="centreid")
	private Diagnostic_center diagnostic_center;
	
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Diagnostic_center getDiagnostic_center() {
		return diagnostic_center;
	}
	public void setDiagnostic_center(Diagnostic_center diagnostic_center) {
		this.diagnostic_center = diagnostic_center;
	}
	*/
	/*
	public int getUsersid() {
		return usersid;
	}
	public void setUsersid(int usersid) {
		this.usersid = usersid;
	}*/
	public String getTestnames() {
		return testnames;
	}
	public void setTestnames(String testnames) {
		this.testnames = testnames;
	}
	public int getCentrenumber() {
		return centrenumber;
	}
	public void setCentrenumber(int centrenumber) {
		this.centrenumber = centrenumber;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getAppointmentstatus() {
		return appointmentstatus;
	}
	public void setAppointmentstatus(String appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}
	public SimpleDateFormat getDatetime() {
		return datetime;
	}
	public void setDatetime(SimpleDateFormat datetime) {
		this.datetime = datetime;
	}
	
}
