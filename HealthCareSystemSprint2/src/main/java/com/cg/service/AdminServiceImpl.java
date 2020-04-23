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
import com.cg.dao.AdminDaoImpl;


@Service
@Transactional
public class AdminServiceImpl implements AdminService 
{
    @Autowired
    AdminDaoImpl dao;

    @Override
    public Diagnostic_center addCenter(Diagnostic_center d) {
	return dao.addCenter(d);
    }

    @Override
    public Diagnostic_center removeCenter(int center_id) {
	return dao.removeCenter(center_id);
    }

    @Override
    public Test addTest(Test t) {
	return dao.addTest(t);
    }

    @Override
    public Test removeTest(int test_id) {
	return dao.removeTest(test_id);
    }
  
       
	@Override
	public Appointment approveAppointment(Appointment a) {
		return dao.approveAppointment(a);
	}
	
	@Override
	public boolean adminLogin(Admindata a) {
		return dao.adminLogin(a);
	}

	@Override
	public Admindata addAdmin(Admindata a) {
		return dao.addAdmin(a);
	}
    
}




/*
@Override
public List<Userdata> getAllUsers() 
{
return dao.getAllUsers();
}
*/



/*
@Override
public Userdata updateUser(Userdata u) {
	return dao.updateUser(u);	
}

@Override
public Boolean loginUser(Userdata u)
{
	return dao.loginUser(u);
}
*/

