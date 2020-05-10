package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Employee employeeCreation(Employee emp) {
		// TODO Auto-generated method stub
		Employee e=em.merge(emp);
		return e;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		
		return em.find(Employee.class,id);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		Query q=em.createQuery("select m from Employee m");
		List<Employee> emplist=q.getResultList();
		return emplist;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Employee e=em.find(Employee.class,emp.getId());
		if(e!=null)
		{
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setPhonenumber(emp.getPhonenumber());
			e.setCompany(emp.getCompany());
		}
		return e;
			
	}
	@Override	
	public Employee deleteById(int id) {
		Employee e=em.find(Employee.class,id);
		if(e!=null)
			{em.remove(e);
			}
        return e;
	}
}
