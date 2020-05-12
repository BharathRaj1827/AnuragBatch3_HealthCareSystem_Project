package com.cg.sprint.controller;

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

import com.cg.sprint.exceptions.IdNotFoundException;
import com.cg.sprint.exceptions.UserNotFoundException;
import com.cg.sprint.bean.Admins;
import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;
import com.cg.sprint.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")

public class AdminController {
	 
	 @Autowired
     private AdminService adminservice;
	 
	    
     @GetMapping("/valid/{adminname}/{adminpassword}")
 	 public ResponseEntity<Admins> validate(@PathVariable("adminname") String aname, @PathVariable("adminpassword") String apwd) throws UserNotFoundException{
 		Admins a= adminservice.validate(aname, apwd);
 		ResponseEntity<Admins> res = new ResponseEntity<Admins>(a,HttpStatus.OK);
 		return res;
 	 }
	 @PutMapping("/approveAppointment")
     public Appointment updateAppoinment(@RequestBody Appointment appointment)
     {
    	 return adminservice.updateAppointment(appointment);
     }
	 @GetMapping(value="/getAllAppointments")
     public List<Appointment> viewAppointment2()
     {
    	 return adminservice.viewAppointment2();
     }
	 @PostMapping(value="/addCenter")
     public String addCenter(@RequestBody()Diagnostic_center center)
     {
    	 adminservice.addCenter(center);
    	 return "Center added successfully";	 
     }
     @GetMapping(value="/getAllCenters")
     public List<Diagnostic_center> viewDiagnostic_center()
     {
    	 return adminservice.viewDiagnostic_center();
     }
     @DeleteMapping("/removeCenter/{centreid}")
     public String removeDiagnostic_center(@PathVariable String centreid) throws IdNotFoundException
     {
    	 adminservice.removeCenter(centreid);
    	 return "Diagnostic_center details removed successfully";
     }
     @PostMapping(value="/addTest")
     public String addTestclass(@RequestBody()Testclass testclass)
     {
    	 adminservice.addTestclass(testclass);
    	 return "Test added successfully";	 
     }    
     @GetMapping(value="/getAllTests")
     public List<Testclass> viewTestclass()
     {
    	 return adminservice.viewTestclass();
     }
     @DeleteMapping("/removeTest/{testid}") 
     public String removeTestclass(@PathVariable String testid) throws IdNotFoundException
     {
    	 adminservice.removeTestclass(testid);
    	 return "Test details removed successfully";
     }
} 


     
    
	    

	 
	
	         
	     
	         
	     
	     
	     
		    