package com.cg.dao;

import java.util.List;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;

public interface UserDao {
	Appointment makeAppointment(Appointment a);

	List<Diagnostic_center> getAllCenters();

	boolean loginUser(Userdata u);
	
	List<Test> getAllTests(int center_id);
	
	Userdata addUser(Userdata u);
	Userdata updateUser(Userdata u);
	Userdata deleteUser(int user_id);

}