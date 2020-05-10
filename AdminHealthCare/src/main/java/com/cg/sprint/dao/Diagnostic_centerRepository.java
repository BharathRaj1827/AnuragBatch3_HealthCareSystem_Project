package com.cg.sprint.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.bean.Diagnostic_center;



public interface Diagnostic_centerRepository extends JpaRepository<Diagnostic_center,Integer>
{
	@Query("select d from Diagnostic_center d")
	List<Diagnostic_center> viewDiagnostic_center();
	
	@Query("select d from Diagnostic_center d")
	List<Diagnostic_center> viewDiagnostic_centers();

}