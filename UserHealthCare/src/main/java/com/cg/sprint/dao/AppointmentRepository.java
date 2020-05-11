package com.cg.sprint.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.bean.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{
	
	@Query("select a from Appointment a where a.usersid=?1")
	List<Appointment> findAllById(String usersid);
	@Query("select a from Appointment a")
	List<Appointment> viewAppointment2();
	@Query("select m.usersid from Appointment m where m.usersid=?1")
	public List<String> checkUserIdEXists(String usersid);
}