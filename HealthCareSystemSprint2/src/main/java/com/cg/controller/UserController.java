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
import com.cg.bean.Userdata;
import com.cg.service.AppointmentService;
import com.cg.service.UserService;


@RestController
@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")

public class UserController {
	 @Autowired
     UserService userservice;
	 AppointmentService appointmentservice;
	 
	 @PostMapping(value="/makeAppointment")
     public Appointment addAppointment(@RequestBody()Appointment appointment)
     {
		 Appointment  a= appointmentservice.addAppointment(appointment);
    	 return a;
     }
	 
	
	  @GetMapping(value="/getUser/{userid}",produces="application/json")
	     public Userdata viewUser(@PathVariable int userid)
	     {
	    	 return userservice.viewUser(userid);
	     }
	     
	     @PostMapping(value="/addUser")
	     public Userdata addUser(@RequestBody()Userdata user)
	     {
	    	 Userdata  u= userservice.addUser(user);
	    	 return u;
	     }
	     
	     @GetMapping(value="/getAllUsers",produces="application/json")
	     public List<Userdata> viewUser()
	     {
	    	 return userservice.viewUser();
	     }
	     
	     @DeleteMapping("/deleteUser/{userid}")
	     public String deleteUser(@PathVariable int userid)
	     {
	    	 userservice.deleteUser(userid);
	    	 return "User Details Deleted";
	     }
	     
	     @PutMapping("/updateUser")
	     public Userdata updateUser(@RequestBody Userdata user)
	     {
	    	 Userdata u=userservice.updateUser(user);
	    	 return u;
	     }
}
