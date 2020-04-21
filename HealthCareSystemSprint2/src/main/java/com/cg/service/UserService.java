package com.cg.service;

import java.util.List;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;

public interface UserService {
	
	Appointment makeAppointment(Appointment a);

	List<Diagnostic_center> getAllCenters();

	boolean loginUser(Userdata u);

	List<Test> getAllTests(int center_id);

	boolean adminLogin(Admindata a);


}
