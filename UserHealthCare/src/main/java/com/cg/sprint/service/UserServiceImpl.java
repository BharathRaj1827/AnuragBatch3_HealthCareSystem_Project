package com.cg.sprint.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bean.Appointment;
import com.cg.sprint.bean.Diagnostic_center;
import com.cg.sprint.bean.Testclass;
import com.cg.sprint.bean.Users;
import com.cg.sprint.dao.AppointmentRepository;
import com.cg.sprint.dao.Diagnostic_centerRepository;
import com.cg.sprint.dao.TestclassRepository;
import com.cg.sprint.dao.UserRepository;



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
    public Users updateUser(Users u)
    {
   		Users ud=ur.findById(u.getUserid()).get();
   		if(ud!=null)
   		{
   			ud.setName(u.getName());
   			ud.setPassword(u.getPassword());
   			ud.setPhonenumber(u.getPhonenumber());
   			ud.setEmail(u.getEmail());
   			ud.setGender(u.getGender());
   			ud.setAge(u.getAge());
   		}
   		return ur.save(ud);
    }
    @Override
    public void deleteUser(int userid)
    {
   	  ur.deleteById(userid);
    }  
	@Override
	public Users validate(String uname, String pwd) {
		return ur.validate(uname, pwd);
	}
	@Override
	public List<Testclass> viewTestclass(int centrenum) {
		return tr.findAllById(centrenum);
	}
	@Override
	public List<Appointment> viewAppointment(int usersid)
    {
   	 return ap.findAllById(usersid);
    }
	@Override
	public Appointment addAppointment(Appointment appointment)
    {
   	 return ap.save(appointment);
    }
	@Override
    public List<Diagnostic_center> viewDiagnostic_centers()
    {
   	 return dr.findAll();
    }

}

