package com.cg.bean;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	private int appointment_id;	
	private String appointment_status;
	private Date date_time;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="appointment_id")
	private Userdata userdata;
	
	@ManyToOne
	@JoinColumn(name="center_id")
	private Diagnostic_center diagnostic_center;
	
	
	
	/*
	@OneToOne(mappedBy="appointment")
	private Userdata userdata;
	*/ 
	
	public Userdata getUserdata() {
		return userdata;
	}
	public void setUserdata(Userdata userdata) {
		this.userdata = userdata;
	}
	public Diagnostic_center getDiagnostic_center() {
		return diagnostic_center;
	}
	public void setDiagnostic_center(Diagnostic_center diagnostic_center) {
		this.diagnostic_center = diagnostic_center;
	}
	
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getAppointment_status() {
		return appointment_status;
	}
	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
}
