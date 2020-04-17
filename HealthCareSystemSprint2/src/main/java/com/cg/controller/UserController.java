package com.cg.controller;

import java.util.List;


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

import com.cg.entity.Appointment;
import com.cg.entity.Diagnostic_center;
import com.cg.exceptions.IdNotFoundException;
import com.cg.service.AdminService;
import com.cg.service.UserService;


@RestController
@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	UserService serviceobj;

	// Making an appointment
	@PostMapping("/makeAppointment")
	public ResponseEntity<String> addUser(@RequestBody Appointment a) {
		Appointment e = serviceobj.makeApponiment(a);
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

	/*
	//Update User
	@PutMapping("/UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody Userdata u) {
		Userdata e = serviceobj.updateUser(u);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	// Delete User
	@DeleteMapping("/DeleteUser/{userId}")
	private ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		Userdata e = serviceobj.deleteUser(userId);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
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
*/
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}