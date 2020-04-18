package com.cg.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserDaoImpl;
import com.cg.entity.Appointment;
import com.cg.entity.Diagnostic_center;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
@Autowired
UserDaoImpl dao;

@Override
public Appointment makeAppointment(Appointment a) {
	return dao.makeAppointment(a);
}

@Override
public List<Diagnostic_center> getAllCenters() 
{
return dao.getAllCenters();
}


}
