package com.cg.dao;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.Userdata;


@Repository
public interface UserRepository extends JpaRepository<Userdata,Serializable>
{

}