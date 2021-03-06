package com.cg.sprint.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.dao.AppointmentRepository;
import com.cg.sprint.dao.Diagnostic_centerRepository;
import com.cg.sprint.dao.TestclassRepository;
import com.cg.sprint.dao.UserRepository;
import com.cg.sprint.dto.Appointment;
import com.cg.sprint.dto.Diagnostic_center;
import com.cg.sprint.dto.Testclass;
import com.cg.sprint.dto.Users;



@Service
@Transactional
public class UserServiceImpl implements UserService
{ 
	
	@Autowired
    private UserRepository ur; 
	@Autowired
    private Diagnostic_centerRepository dr;
	@Autowired
    private TestclassRepository tr; 
	@Autowired
    private AppointmentRepository ap;
	

    @Override
    public Users addUser(Users user)
    {
   	 return ur.save(user);
    }
  
	@Override
	public Users validate(String uname, String pwd) {
		return ur.validate(uname, pwd);
	}
	@Override
	public List<Testclass> viewTestclass(String centrenum) {
		return tr.findAllById(centrenum);
	}
	@Override
	public List<Appointment> viewAppointment(String usersid)
    {
   	 return ap.findAllById(usersid);
    }
	
	public Boolean userIdFound(String usersid){
		List<String> exists=ap.checkUserIdEXists(usersid);
		 return exists.isEmpty();
	
	}
	@Override
	public String makeAppointment(Appointment app) {
		ap.save(app);
		return "Appointment is registered, please await for confirmation";
	}
	@Override
    public List<Diagnostic_center> viewDiagnostic_centers()
    {
   	 return dr.findAll();
    }
	
}

