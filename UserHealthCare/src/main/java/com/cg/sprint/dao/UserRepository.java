package com.cg.sprint.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.dto.Users;


public interface UserRepository extends JpaRepository<Users,Integer>
{

	@Query("select a from Users a where name=?1 and password=?2 ")
	public Users validate(String uname, String pwd);
	
}