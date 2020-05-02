package com.cg.service;

import java.util.List;

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.dao.AdminRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestRepository;


public interface AdminService {
	
	Admins validate(String aname, String apwd);
	
	List<Diagnostic_center> viewDiagnostic_center();
	List<Test> viewTest();

	void addCenter(Diagnostic_center center);
	void removeCenter(int centreid);
	void addTest(Test test);
	void removeTest(int testid);

	Appointment updateAppointment(Appointment a);
	List<Appointment> viewAppointment1(int centrenumber);

	List<Appointment> viewAppointment2();


	

}