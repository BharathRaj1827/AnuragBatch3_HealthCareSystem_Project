package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="diagnostic_center")
public class Diagnostic_center {
	
	@Id
	@Column(name="center_id")
	private int center_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="appointment_id")
	
	@Column(name="center_name")
	private String center_name;
	@Column(name="contact_no")
	private long contact_no;
	@Column(name="address")
	private String address;
	
	
	
	
	
	public int getCenter_id() {
		return center_id;
	}
	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}
	public String getCenter_name() {
		return center_name;
	}
	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
