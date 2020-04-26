package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Users;
import com.cg.service.AppointmentService;
import com.cg.service.Diagnostic_centerService;
import com.cg.service.TestService;
import com.cg.service.UserServiceImpl;


@RestController
@RequestMapping("/admin")
//@CrossOrigin("http://localhost:4200")

public class AdminController {
	
	 @Autowired
	 AppointmentService appointmentservice;
	 
	 @Autowired
	 Diagnostic_centerService Diagnostic_centerservice;
	 
	 @Autowired
     TestService testservice;
	 
	
	 @GetMapping(value="/getAppointment/{appointment_id}",produces="application/json")
	     public Appointment viewAppointment(@PathVariable int appointment_id)
	     {
	    	 return appointmentservice.viewAppointment(appointment_id);
	     }
	     

	     @GetMapping(value="/getAllAppointments",produces="application/json")
	     public List<Appointment> viewAppointment()
	     {
	    	 return appointmentservice.viewAppointment();
	     }
	     
	     /*
	     @DeleteMapping("/deleteUser/{userid}")
	     public String deleteUser(@PathVariable int userid)
	     {
	    	 userservice.deleteUser(userid);
	    	 return "User Details Deleted";
	     }*/
	     
	     @PutMapping("/approveAppointment")
	     public Appointment updateAppoinment(@RequestBody Appointment appointment)
	     {
	    	 Appointment a=appointmentservice.updateAppointment(appointment);
	    	 return a;
	     }
	     
	     
	     
		  
		 /*
		 @GetMapping(value="/getUser/{userid}",produces="application/json")
		     public Userdata viewUser(@PathVariable int userid)
		     {
		    	 return userservice.viewUser(userid);
		     }*/
		     
		     @PostMapping(value="/addCenter")
		     public Diagnostic_center addCenter(@RequestBody()Diagnostic_center center)
		     {
		    	 Diagnostic_center  dc= Diagnostic_centerservice.addCenter(center);
		    	 return dc;
		     }
		     
		     @GetMapping(value="/getAllCenters",produces="application/json")
		     public List<Diagnostic_center> viewDiagnostic_center()
		     {
		    	 return Diagnostic_centerservice.viewDiagnostic_center();
		     }
		     
		     @DeleteMapping("/removeCenter/{center_id}")
		     public String removeDiagnostic_center(@PathVariable int center_id)
		     {
		    	 Diagnostic_centerservice.removeCenter(center_id);
		    	 return "Diagnostic_center Details Removed";
		     }
		     
		     /*
		     @PutMapping("/updateUser")
		     public Userdata updateUser(@RequestBody Userdata user)
		     {
		    	 Userdata u=userservice.updateUser(user);
		    	 return u;
		     }*/

		     
		     
		    
			  
			 /*
			 @GetMapping(value="/getUser/{userid}",produces="application/json")
			     public Userdata viewUser(@PathVariable int userid)
			     {
			    	 return userservice.viewUser(userid);
			     }*/
			     
			     @PostMapping(value="/addTest")
			     public Test addTest(@RequestBody()Test test)
			     {
			    	 Test  t= testservice.addTest(test);
			    	 return t;
			     }
			     
			     @GetMapping(value="/getAllTests",produces="application/json")
			     public List<Test> viewTest()
			     {
			    	 return testservice.viewTest();
			     }
			     
			     @DeleteMapping("/removeTest/{test_id}")
			     public String removeTest(@PathVariable int test_id)
			     {
			    	 testservice.removeTest(test_id);
			    	 return "Test Details Removed";
			     }
			     
			     /*
			     @PutMapping("/updateUser")
			     public Userdata updateUser(@RequestBody Userdata user)
			     {
			    	 Userdata u=userservice.updateUser(user);
			    	 return u;
			     }*/ 
} 
