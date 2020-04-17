package com.cg.dao;


import java.util.List;

import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;

public interface AdminDao {

	Diagnostic_center addCenter(Diagnostic_center d);
	Diagnostic_center removeCenter(int centerId);
	
	Test addTest(Test t);
	Test removeTest(int testId);
	
	
	//List<Diagnostic_center> getAllCenters();

	//diagnostic_center updateUser(Userdata u);

	//Boolean loginUser(Userdata u);
	
	
	
}