package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.dao.AdminRepository;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService
{

	 @Autowired
     private AdminRepository ar;
	 @Autowired
     private Diagnostic_centerRepository dr;
	 @Autowired
     private TestRepository tr; 
	 @Autowired
     private AppointmentRepository ap;
	
	
	@Override
	public Admins validate(String aname, String apwd) {
		return ar.validate(aname, apwd);
	}
	
    	
	 @Override
     public List<Diagnostic_center> viewDiagnostic_center()
     {
    	 return dr.findAll();
     }
     
     
     @Override
     public void addCenter(Diagnostic_center center)
     {
    	  dr.save(center);
     }
     
     @Override
     public void removeCenter(int centreid)
     {
    	  dr.deleteById(centreid);
     }
	
	
    @Override 
	public List<Test> viewTest()
     {
    	 return tr.findAll();
     }
     
   
    @Override
     public void addTest(Test test)
     {
    	 tr.save(test);
     }
     
    @Override
     public void removeTest(int testid)
     {
    	  tr.deleteById(testid);
     }
    
    
    @Override
    public List<Appointment> viewAppointment1(int centrenumber)
    {
      	 return ap.findAllById(centrenumber);
    }
    
    
    @Override
    public List<Appointment> viewAppointment2()
    {
      	 return ap.findAll();
    }
     
	
    @Override
    public Appointment updateAppointment(Appointment a)
    {
   	 Appointment ud=ap.findById(a.getAppointmentid()).get();
   		if(ud!=null)
   		{
   			ud.setAppointmentstatus(a.getAppointmentstatus());
   			ud.setDatetime(a.getDatetime());
   		}
   		return ap.save(ud);
    }

    /*
 	@Override
 	public String updateCenter(Diagnostic_center d) {
 		boolean bool = diagnostic_center.existsById(d.getCenterid());
 		if(bool == true) {
 			diagnostic_center.save(d);
 			return "Center updated successfully!!";
 		}
 		else {
 			return "center not updated";
 		}
 	}*/
    	
}