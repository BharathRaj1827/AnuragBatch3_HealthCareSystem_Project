package com.cg.controller;


import java.util.List;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;
import com.cg.exceptions.IdNotFoundException;
import com.cg.service.AdminService;
import com.cg.exceptions.UserNotFoundException;

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
@RequestMapping("/admin")
//@CrossOrigin("http://localhost:4200")

public class AdminController {
	@Autowired
	AdminService serviceobj;

	// Add Center
	
	@PostMapping("/addCenter")
	public ResponseEntity<String> addCenter(@RequestBody Diagnostic_center d) {
		Diagnostic_center dc = serviceobj.addCenter(d);
		if (dc == null) {
			throw new IdNotFoundException("Enter required Center details");
		} else {
			return new ResponseEntity<String>("Center added successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	
	// Remove center
	
	@DeleteMapping("/removeCenter/{center_id}")
	private ResponseEntity<String> removeCenter(@PathVariable("center_id") int center_id) {
		Diagnostic_center d = serviceobj.removeCenter(center_id);
		if (d == null) {
			throw new IdNotFoundException("Remove Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Center removed successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	// Add Test
	
		@PostMapping("/addTest")
		public ResponseEntity<String> addTest(@RequestBody Test t) {
			Test tt = serviceobj.addTest(t);
			if (tt == null) {
				throw new IdNotFoundException("Enter required Test details");
			} else {
				return new ResponseEntity<String>("Test added successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		
		
		// Remove Test
		
		@DeleteMapping("/removeTest/{test_id}")
		private ResponseEntity<String> removeTest(@PathVariable("test_id") int test_id) {
			Test t = serviceobj.removeTest(test_id);
			if (t == null) {
				throw new IdNotFoundException("Remove Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Test removed successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		
		//approve appointment
		
		@PutMapping("/approveAppointment")
		public ResponseEntity<String> approveAppointment(@RequestBody Appointment a) {
			Appointment aa = serviceobj.approveAppointment(a);
			if (aa == null) {
				throw new IdNotFoundException("Approve Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Appointment approved successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		
		
		@PostMapping("/addAdmin")
		public ResponseEntity<String> addAdmin(@RequestBody Admindata a) {
			Admindata e = serviceobj.addAdmin(a);
			if (e == null) {
				throw new IdNotFoundException("Enter Valid Id");
			} else {
				return new ResponseEntity<String>("Admin created successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
	
		
		
		
		 

	
		
		
		// Add user 
				@PostMapping("/addUser")
				public ResponseEntity<String> addUser(@RequestBody Userdata u) {
					Userdata e = serviceobj.addUser(u);
					if (e == null) {
						throw new IdNotFoundException("Enter Valid Id");
					} else {
						return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
					}
				}
			
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
				@DeleteMapping("/DeleteUser/{user_id}")
				private ResponseEntity<String> deleteUser(@PathVariable("user_id") int user_id) {
					Userdata e = serviceobj.deleteUser(user_id);
					if (e == null) {
						throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
					} else {
						return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
					}
				}	
	
}

	
	
	