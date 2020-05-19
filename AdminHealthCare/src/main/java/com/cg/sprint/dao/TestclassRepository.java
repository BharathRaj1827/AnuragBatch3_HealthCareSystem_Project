package com.cg.sprint.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.dto.Testclass;


public interface TestclassRepository extends JpaRepository<Testclass,Serializable>
{
	@Query("select t from Testclass t where t.centrenum=?1")
	List<Testclass> findAllById(String centrenum);

	@Query("select t from Testclass t")
	List<Testclass> viewTest();

}