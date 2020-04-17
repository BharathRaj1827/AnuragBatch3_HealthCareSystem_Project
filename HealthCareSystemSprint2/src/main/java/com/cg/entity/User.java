package com.cg.entity;
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
@Table(name = "User")
public class User{
		@Id
		@Column(name="user_id")
		private int user_id;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="appointment_id")
		
		@Column(name="age")
		private int age;
		@Column(name="gender")
		private String gender;
		@Column(name="contact_no")
		private long contact_no;
		@Column(name="user_name")
		private String user_name;
		@Column(name="password")
		private String password;
		@Column(name="user_email")
		private String user_email;
		
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
		public long getContact_no() {
			return contact_no;
		}
		public void setContact_no(long contact_no) {
			this.contact_no = contact_no;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		
	}

