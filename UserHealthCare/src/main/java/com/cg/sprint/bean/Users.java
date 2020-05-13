package com.cg.sprint.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class Users{
		@Id
		@Column(name="userid",length=20)
		private String userid;
		@Column(name="name",length=25)
		private String name;
		@Column(name="age",length=3)
		private int age;
		@Column(name="gender",length=10)
		private String gender;
		@Column(name="phonenumber",length=10)
		private long phonenumber;
		@Column(name="password",length=20)
		private String password;
		@Column(name="email",length=30)
		private String email;
		
        
		public Users(){}
		public Users(String userid, String name, int age, String gender, long phonenumber, String password, String email) {
			this.userid = userid;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.phonenumber = phonenumber;
			this.password = password;
			this.email = email;
		}
	
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
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
	}

