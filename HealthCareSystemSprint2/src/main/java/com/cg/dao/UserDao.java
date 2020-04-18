package com.cg.dao;

import java.util.List;

import com.cg.entity.Appointment;
import com.cg.entity.Diagnostic_center;

public interface UserDao {
	Appointment makeAppointment(Appointment a);

	List<Diagnostic_center> getAllCenters();
}