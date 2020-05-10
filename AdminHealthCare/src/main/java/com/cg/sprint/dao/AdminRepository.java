package com.cg.sprint.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.bean.Admins;



public interface AdminRepository extends JpaRepository<Admins,Integer>
{

	
	@Query("select a from Admins a where adminname=?1 and adminpassword=?2 ")
	Admins validate(String aname, String apwd);

}