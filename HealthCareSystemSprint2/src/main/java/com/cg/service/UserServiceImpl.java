package com.cg.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;
import com.cg.dao.UserDaoImpl;

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


@Override
public List<Test> getAllTests(int center_id) 
{
return dao.getAllTests(center_id);
}

@Override
public boolean adminLogin(Admindata a) {
	return dao.adminLogin(a);
}

@Override
public boolean loginUser(Userdata u) {
	return dao.loginUser(u);
}


}
