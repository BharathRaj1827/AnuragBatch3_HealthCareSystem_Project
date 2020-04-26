package com.cg.bean;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class Users{
		@Id
		private int userid;
		private int age;
		private String gender;
		private long phonenumber;
		private String name;
		private String password;
		private String email;
		

		@OneToOne(mappedBy="users")
		private Appointment appointment;
		
		
		
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public long getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(long phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		/*
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="user_id")
		private Appointment appointment;
		*/
		
		
		
		public Appointment getAppointment() {
			return appointment;
		}
		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}
		
		
		
	}

