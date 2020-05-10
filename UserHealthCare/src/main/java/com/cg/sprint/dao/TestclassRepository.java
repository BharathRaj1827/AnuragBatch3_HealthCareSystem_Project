package com.cg.sprint.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.sprint.bean.Testclass;



public interface TestclassRepository extends JpaRepository<Testclass,Integer>
{
	@Query("select t from Testclass t where centrenum=?1")
	List<Testclass> findAllById(int centreid);

	@Query("select t from Testclass t")
	List<Testclass> viewTestclass();


}