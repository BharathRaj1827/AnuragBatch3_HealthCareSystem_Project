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
import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;
import com.cg.sprint.bean.Users;
import com.cg.sprint.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4300")

public class UserController {
	
	 @Autowired
     private UserService userservice;
	 
	 
	 @GetMapping("/valid/{name}/{password}")
	 public ResponseEntity<Users> validate(@PathVariable("name") String uname, @PathVariable("password") String pwd) throws UserNotFoundException{
	    Users us = userservice.validate(uname, pwd);
	 	ResponseEntity<Users> res = new ResponseEntity<Users>(us,HttpStatus.OK);
	 	return res;
	 }
	/* 
	 @PostMapping(value="/makeAppointment")
     public Appointment addAppointment(@RequestBody()Appointment appointment)
     {
		 return userservice.addAppointment(appointment);
     }*/

		@PostMapping("/makeAppointment")
		public ResponseEntity<Boolean> updateAppointment(@RequestBody Appointment app) {
			Boolean exists = userservice.userIdFound(app.getUsersid());
			if (exists) {
				System.out.println(exists);
				userservice.makeAppointment(app);
				return new ResponseEntity<>(true, HttpStatus.OK);
			} else {
				throw new IdNotFoundException("Sorry! User Id exists");
			}
		}

	 @GetMapping(value="/getAppointment/{usersid}")
     public List<Appointment> viewAppointment(@PathVariable("usersid") String usersid) throws IdNotFoundException
     {
    	 return userservice.viewAppointment(usersid);
     }
     @PostMapping(value="/addUser")
     public Users addUser(@RequestBody()Users user)
     {
    	 return userservice.addUser(user);
    	
     }
   /*  @DeleteMapping("/deleteUser/{userid}")
     public String deleteUser(@PathVariable String userid) throws IdNotFoundException
     {
    	 userservice.deleteUser(userid);
    	 return "User Details Deleted";
     }*/
     /*@PutMapping("/updateUser")
     public Users updateUser(@RequestBody Users user)
     {
    	 return userservice.updateUser(user);
    	 
     }*/
     @GetMapping(value="/getAllCenters")
     public List<Diagnostic_center> viewDiagnostic_centers()
     {
    	 return userservice.viewDiagnostic_centers();
     }
     @GetMapping(value="/getAllTests/{centrenum}")
     public List<Testclass> viewTestclass(@PathVariable("centrenum") String centrenum) throws IdNotFoundException
     {
    	 return userservice.viewTestclass(centrenum);
     }	     	    
}

	 
	 