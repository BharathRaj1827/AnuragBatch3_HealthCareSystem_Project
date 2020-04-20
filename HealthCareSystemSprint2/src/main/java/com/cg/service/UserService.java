package com.cg.service;

import java.util.List;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Userdata;

public interface UserService {
	
	Appointment makeAppointment(Appointment a);

	List<Diagnostic_center> getAllCenters();

	boolean loginUser(Userdata u);


}
