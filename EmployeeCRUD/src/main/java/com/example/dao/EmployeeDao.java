package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDao {

	Employee deleteById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	Employee employeeCreation(Employee emp);

	Employee updateEmployee(Employee emp);
}
