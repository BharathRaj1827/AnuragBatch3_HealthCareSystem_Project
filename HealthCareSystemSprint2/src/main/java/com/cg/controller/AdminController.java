package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.service.AdminService;





@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")

public class AdminController {
	 
	 @Autowired
     private AdminService adminservice;
	 
	 
	 @PutMapping("/approveAppointment")
     public Appointment updateAppoinment(@RequestBody Appointment appointment)
     {
    	 return adminservice.updateAppointment(appointment);
     }
	 
	/*
	 @GetMapping(value="/getAppointment/{appointmentid}")
	     public Appointment viewAppointment(@PathVariable("appointmentid") int appointmentid)
	     {
	    	 return adminservice.viewAppointment(appointmentid);
	     }
	  */ 

	     @GetMapping(value="/getAllAppointments/{centreid}")
	     public List<Appointment> viewAppointment1(@PathVariable("centreid") int centreid)
	     {
	    	 return adminservice.viewAppointment1(centreid);
	     }
	         
	     
	     
	     
		     @PostMapping(value="/addCenter")
		     public String addCenter(@RequestBody()Diagnostic_center center)
		     {
		    	 adminservice.addCenter(center);
		    	 return "Center added";	 
		     }
		     
		     @GetMapping(value="/getAllCenters")
		     public List<Diagnostic_center> viewDiagnostic_center()
		     {
		    	 return adminservice.viewDiagnostic_center();
		     }
		    
		     
		     
		     
		     
		     @DeleteMapping("/removeCenter/{centreid}")
		     public String removeDiagnostic_center(@PathVariable int centreid)
		     {
		    	 adminservice.removeCenter(centreid);
		    	 return "Diagnostic_center Details Removed";
		     }
		     
			     @PostMapping(value="/addTest/{centreid}")
			     public String addTest(@PathVariable int centreid,@RequestBody()Test test)
			     {
			    	 adminservice.addTest(centreid);
			    	 return "Test added";	 
			     }
			     
			     @GetMapping(value="/getAllTests")
			     public List<Test> viewTest()
			     {
			    	 return adminservice.viewTest();
			     }
			     
			    
			     
			     
			     
			     
			     
			     @DeleteMapping("/removeTest/{testid}")
			     public String removeTest(@PathVariable int testid)
			     {
			    	 adminservice.removeTest(testid);
			    	 return "Test Details Removed";
			     }
			     
			     
			     @GetMapping("/valid/{adminname}/{adminpassword}")
			 	public ResponseEntity<Admins> validate(@PathVariable("adminname") String aname, @PathVariable("adminpassword") String apwd) {
			 		Admins a= adminservice.validate(aname, apwd);
			 		ResponseEntity<Admins> res = new ResponseEntity<Admins>(a,HttpStatus.OK);
			 		return res;
			 	}
			     
			     
			     
			     
} 


