package com.cg.sprint.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "Appointment")

public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name="appointmentid",nullable=false,updatable=false)
	private int appointmentid;	
	@Column(name="appointmentstatus")
	private boolean appointmentstatus;
	@Column(name="datetime",length=25)
	private String datetime;
	@Column(name="centrenumber",length=10)
	private String centrenumber;
	@Column(name="testnames",length=15)
	private String testnames;
	@Column(name="usersid",length=10)
	private String usersid;
	
	public Appointment() {}
	public Appointment(int appointmentid, boolean appointmentstatus, String datetime, String centrenumber, String testnames,String usersid) {
		
		this.appointmentid = appointmentid;
		this.appointmentstatus = appointmentstatus;
		this.datetime = datetime;
		this.centrenumber = centrenumber;
		this.testnames = testnames;
		this.usersid=usersid;
	}
	
	public String getUsersid() {
		return usersid;
	}
	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}
	public String getTestnames() {
		return testnames;
	}
	public void setTestnames(String testnames) {
		this.testnames = testnames;
	}
	public String getCentrenumber() {
		return centrenumber;
	}
	public void setCentrenumber(String centrenumber) {
		this.centrenumber = centrenumber;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public boolean getAppointmentstatus() {
		return appointmentstatus;
	}
	public void setAppointmentstatus(boolean appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
