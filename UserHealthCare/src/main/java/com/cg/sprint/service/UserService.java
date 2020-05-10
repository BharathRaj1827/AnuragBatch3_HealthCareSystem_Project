package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;
import com.cg.sprint.bean.Users;



public interface UserService {
	
	Users validate(String uname, String pwd);
	List<Testclass> viewTestclass(int centrenum);

	Users addUser(Users user);
	Users updateUser(Users user);
	void deleteUser(int userid);

	Appointment addAppointment(Appointment appointment);
	Appointment viewAppointment(int appointmentid);

	List<Diagnostic_center> viewDiagnostic_centers();


	

}