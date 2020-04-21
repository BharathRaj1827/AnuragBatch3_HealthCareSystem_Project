package com.cg.controller;

import java.util.List;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;
import com.cg.exceptions.IdNotFoundException;
import com.cg.exceptions.UserNotFoundException;
import com.cg.service.UserService;
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


@RestController
@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	UserService serviceobj;

	// Making an appointment
	@PostMapping("/makeAppointment")
	public ResponseEntity<String> addUser(@RequestBody Appointment a) {
		Appointment e = serviceobj.makeAppointment(a);
		if (e == null) {
			throw new IdNotFoundException("Unsuccessfull");
		} else {
			return new ResponseEntity<String>("Apponitment made successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	
	// Get all Centers
	@GetMapping("/GetAllCenters")
	private ResponseEntity<List<Diagnostic_center>> getAllCenters() {
		List<Diagnostic_center> centerlist = serviceobj.getAllCenters();
		return new ResponseEntity<List<Diagnostic_center>>(centerlist, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/GetAllTests/{center_id}")
	private ResponseEntity<List<Test>> getAllTests(@PathVariable("center_id") int center_id) {
		List<Test> testlist = serviceobj.getAllTests(center_id);
		if (testlist == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
		return new ResponseEntity<List<Test>>(testlist, new HttpHeaders(), HttpStatus.OK);
		}
	}
	
		
	
		
	
	@PutMapping("/Loginuser")
	public ResponseEntity<String> loginUser(@RequestBody Userdata u)
	{
		
		 boolean flag=serviceobj.loginUser(u);
		if(flag==false)
		{
			throw new UserNotFoundException("User not found");
		}else {
			return new ResponseEntity<String>("Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}


	//admin login
	@PutMapping("/Adminlogin")
	public ResponseEntity<String> adminLogin(@RequestBody Admindata a)
	{
		
		 boolean flag=serviceobj.adminLogin(a);
		if(flag==false)
		{
			throw new UserNotFoundException("User not found");
		}else {
			return new ResponseEntity<String>("Admin Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}
	

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> IdNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
