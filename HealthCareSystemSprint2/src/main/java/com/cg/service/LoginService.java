package com.cg.service;


import java.util.List;

import com.cg.entity.Userdata;

public interface LoginService {

	Userdata addUser(Userdata u);


	List<Userdata> getAllUsers();

	Userdata deleteUser(int userId);

	Userdata updateUser(Userdata u);
	
	Boolean loginUser(Userdata u);


	Boolean adminLoginUser(Userdata u);

}