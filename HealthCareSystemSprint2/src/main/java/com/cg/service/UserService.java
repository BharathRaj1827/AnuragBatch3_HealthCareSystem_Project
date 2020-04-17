package com.cg.service;

import java.util.List;

import com.cg.entity.Appointment;
import com.cg.entity.Diagnostic_center;

public interface UserService {

	List<Diagnostic_center> getAllCenters();

	Appointment makeApponiment(Appointment a);
	
}
