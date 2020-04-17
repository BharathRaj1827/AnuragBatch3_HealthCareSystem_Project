package com.cg.entity;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
@Table(name = "Appointment")

public class Appointment {
	@Id
	@Column(name="appointment_id")
	private int appointment_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	
	//@Column(name="USER_ID")
	//private int user_id;
	
	
	@Column(name="appointment_status")
	private String appointment_status;
	@Column(name="date_time")
	private Date date_time;
	
	
	
	
	
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
