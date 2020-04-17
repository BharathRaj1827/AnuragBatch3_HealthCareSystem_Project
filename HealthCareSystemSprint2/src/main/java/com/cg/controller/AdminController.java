package com.cg.controller;


import java.util.List;

import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;
import com.cg.exceptions.IdNotFoundException;
import com.cg.service.AdminService;
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
	
	@DeleteMapping("/removeCenter/{centerId}")
	private ResponseEntity<String> removeCenter(@PathVariable("centerId") int centerId) {
		Diagnostic_center d = serviceobj.removeCenter(centerId);
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
		
		@DeleteMapping("/removeTest/{testId}")
		private ResponseEntity<String> removeTest(@PathVariable("testId") int testId) {
			Test t = serviceobj.removeTest(testId);
			if (t == null) {
				throw new IdNotFoundException("Remove Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Test removed successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

	
	
}

	
	
	