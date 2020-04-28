package com.cg.bean;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
@Table(name = "Appointment")

public class Appointment {
	@Id
	private int appointmentid;	
	private String appointmentstatus;
	private Date datetime;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="appointmentid")
	private Users users;
	
	@ManyToOne
	@JoinColumn(name="centreid")
	private Diagnostic_center diagnostic_center;
	
	
	/*
	@OneToOne(mappedBy="appointment")
	private Userdata userdata;
	*/ 
	
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
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
