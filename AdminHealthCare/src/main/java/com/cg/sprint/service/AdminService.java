package com.cg.sprint.service;
import java.util.List;

import com.cg.sprint.bean.Admins;
import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;


public interface AdminService {
	
	Admins validate(String aname, String apwd);
	List<Diagnostic_center> viewDiagnostic_center();
	List<Testclass> viewTestclass();
	Diagnostic_center addCenter(Diagnostic_center center);
	void removeCenter(String centreid);
	Testclass addTestclass(Testclass testclass);
	void removeTestclass(String testid);
	Appointment updateAppointment(Appointment a);
	List<Appointment> viewAppointment2();
}