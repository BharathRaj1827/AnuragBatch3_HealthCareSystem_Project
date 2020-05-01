package com.cg.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{
	@Query("select a from Appointment a where centrenumber=?1")
	List<Appointment> viewAppointment1(int centreid);

	List<Appointment> findAllById(int centreid);
}