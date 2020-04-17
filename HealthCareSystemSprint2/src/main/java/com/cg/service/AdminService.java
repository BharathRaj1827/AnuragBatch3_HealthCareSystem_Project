package com.cg.service;


import java.util.List;

import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;

public interface AdminService {

	Diagnostic_center addCenter(Diagnostic_center d);
	Diagnostic_center removeCenter(int centerId);
	Test addTest(Test t);
	Test removeTest(int testId);
	
	
	//List<Userdata> getAllUsers();

	//Userdata updateUser(Userdata u);
	
	//Boolean loginUser(Userdata u);

}