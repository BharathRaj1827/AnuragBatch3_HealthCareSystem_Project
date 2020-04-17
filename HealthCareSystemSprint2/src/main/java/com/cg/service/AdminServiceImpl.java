package com.cg.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AdminDaoImpl;
import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;

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
    public Diagnostic_center removeCenter(int centerId) {
	return dao.removeCenter(centerId);
    }

    @Override
    public Test addTest(Test t) {
	return dao.addTest(t);
    }

    @Override
    public Test removeTest(int testId) {
	return dao.removeTest(testId);
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

