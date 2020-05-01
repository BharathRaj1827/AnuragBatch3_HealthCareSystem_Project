package com.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Appointment;
import com.cg.bean.Test;
import com.cg.bean.Users;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.UserRepository;

public interface UserService {
	
	Users validate(String uname, String pwd);
	//Users viewUser(int userid);

	//List<Users> viewUser();
	List<Test> viewTest(int centreid);

	Users addUser(Users user);
	Users updateUser(Users user);
	void deleteUser(int userid);

	Appointment addAppointment(Appointment appointment);
	Appointment viewAppointment(int appointmentid);


	

}