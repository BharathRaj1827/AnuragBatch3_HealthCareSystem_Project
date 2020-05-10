package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.dao.EmployeeDaoImpl;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService 
{
@Autowired
EmployeeDaoImpl dao;

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#EmployeeCreation(com.example.entity.Employee)
 */
@Override
public Employee employeeCreation(Employee emp) {
	return dao.employeeCreation(emp);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getEmployeeById(int)
 */
@Override
public Employee getEmployeeById(int id) 
{
return dao.getEmployeeById(id);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getAllEmployee()
 */
@Override
public List<Employee> getAllEmployee() 
{
return dao.getAllEmployee();
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#delete(int)
 */
@Override
public Employee delete(int id) 
{
	return dao.deleteById(id);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#UpdateEmployee(com.example.entity.Employee)
 */
@Override
public Employee updateEmployee(Employee emp) {
	return dao.updateEmployee(emp);	
}

}