package com.cg.service;


import java.util.List;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;


public interface AdminService {

	Diagnostic_center addCenter(Diagnostic_center d);
	Diagnostic_center removeCenter(int center_id);
	Test addTest(Test t);
	Test removeTest(int test_id);
	Appointment approveAppointment(Appointment a);
	boolean adminLogin(Admindata a);
	Userdata addUser(Userdata u);
	Userdata updateUser(Userdata u);
	Userdata deleteUser(int user_id);
	
	
	//List<Userdata> getAllUsers();

	
	//Boolean loginUser(Userdata u);

}