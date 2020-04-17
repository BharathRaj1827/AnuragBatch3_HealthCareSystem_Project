package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="test")
public class Test {
	@Id
	@Column(name="test_id")
	private int test_id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="center_id")
	
	@Column(name="test_name")
	private String test_name;
	
public int getTest_id() {
	return test_id;
}
public void setTest_id(int test_id) {
	this.test_id = test_id;
}
public String getTest_name() {
	return test_name;
}
public void setTest_name(String test_name) {
	this.test_name = test_name;
}
}