package com.example.controller;

import java.util.List;

import com.example.exceptions.IdNotFoundException;
import com.example.service.EmployeeService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeService serviceobj;

	// Create Employee
	@PostMapping("/EmployeeCreation")
	public ResponseEntity<String> employeeCreation(@RequestBody Employee emp) {
		Employee e = serviceobj.employeeCreation(emp);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Employee created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Employee Data
	@GetMapping("/GetEmployee/{id}")
	private ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee e = serviceobj.getEmployeeById(id);
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Employee>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Employees Data
	@GetMapping("/GetAllEmployees")
	private ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emplist = serviceobj.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Employee data
	@PutMapping("/UpdateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		Employee e = serviceobj.updateEmployee(emp);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Employee updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Employee
	@DeleteMapping("/DeleteEmployee/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		Employee e = serviceobj.delete(id);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Employee deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
