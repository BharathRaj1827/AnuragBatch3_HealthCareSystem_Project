package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {

	Employee employeeCreation(Employee emp);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	Employee delete(int id);

	Employee updateEmployee(Employee emp);

}