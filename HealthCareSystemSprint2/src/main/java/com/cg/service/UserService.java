package com.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Userdata;
import com.cg.dao.UserRepository;

public interface UserService {

	void setUdao(UserRepository udao);

	Userdata viewUser(int userid);

	List<Userdata> viewUser();

	Userdata addUser(Userdata user);

	Userdata updateUser(Userdata u);

	void deleteUser(int user_id);

}