package com.cg.bean;

import javax.persistence.Entity;

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
	private int center_id;
	private String center_name;
	private long contact_no;
	private String address;
	
	@OneToMany(mappedBy="diagnostic_center", cascade=CascadeType.ALL)
	private List<Test> test= new ArrayList<Test>();
	
	@OneToMany(mappedBy="diagnostic_center", cascade=CascadeType.ALL)
	private List<Appointment> appointment= new ArrayList<Appointment>();
	
	
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
