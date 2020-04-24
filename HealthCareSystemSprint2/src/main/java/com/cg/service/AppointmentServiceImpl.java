package com.cg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Appointment;
import com.cg.bean.Test;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.TestRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService
{
     @Autowired
     AppointmentRepository udao;
 

	/* (non-Javadoc)
	 * @see com.cg.service.AppointmentService#setUdao(com.cg.dao.AppointmentRepository)
	 */
	@Override
	public void setUdao(AppointmentRepository udao) { this.udao=udao; }
    
	
     /* (non-Javadoc)
	 * @see com.cg.service.AppointmentService#viewAppointment(int)
	 */
    @Override
	@Transactional(readOnly=true)
     public Appointment viewAppointment(int appointment_id)
     {
    	 return udao.findById(appointment_id).get();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.AppointmentService#viewAppointment()
	 */
    @Override
	@Transactional(readOnly=true)
     public List<Appointment> viewAppointment()
     {
    	 return udao.findAll();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.AppointmentService#addAppointment(com.cg.bean.Appointment)
	 */
    @Override
	@Transactional
     public Appointment addAppointment(Appointment appointment)
     {
    	 return udao.save(appointment);
     }
     
     
     /* (non-Javadoc)
	 * @see com.cg.service.AppointmentService#updateAppointment(com.cg.bean.Appointment)
	 */
    @Override
	@Transactional
     public Appointment updateAppointment(Appointment a)
     {
    	 Appointment ud=udao.findById(a.getAppointment_id()).get();
    		if(ud!=null)
    		{
    			ud.setAppointment_status(a.getAppointment_status());
    			ud.setDate_time(a.getDate_time());
    		}
    		return udao.save(ud);
     }
     
     /*
     
     @Transactional
     public void removeTest(int test_id)
     {
    	  udao.deleteById(test_id);
     }*/
}
