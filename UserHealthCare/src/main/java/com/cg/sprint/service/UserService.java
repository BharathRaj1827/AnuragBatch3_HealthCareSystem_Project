package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;
import com.cg.sprint.bean.Users;

public interface UserService {
	
	Users validate(String uname, String pwd);
	List<Testclass> viewTestclass(String centrenum);
	Users addUser(Users user);
	//Users updateUser(Users user);
	//void deleteUser(String userid);
	//Appointment addAppointment(Appointment appointment);
	List<Appointment> viewAppointment(String usersid);
	List<Diagnostic_center> viewDiagnostic_centers();
	Boolean userIdFound(String usersid);
	String makeAppointment(Appointment app);
}
