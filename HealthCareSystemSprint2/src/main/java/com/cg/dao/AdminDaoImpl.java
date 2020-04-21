package com.cg.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bean.Admindata;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Test;
import com.cg.bean.Userdata;


@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Diagnostic_center addCenter(Diagnostic_center d) {
		Diagnostic_center e=em.merge(d);
		return e;
	}
	
	
	
	@Override	
	public Diagnostic_center removeCenter(int center_id) {
		Diagnostic_center d=em.find(Diagnostic_center.class,center_id);
		if(d!=null)
			{em.remove(d);
			}
        return d;
	}
        
        @Override
    	public Test addTest(Test t) {
    		Test e=em.merge(t);
    		return e;
    	}
    	
    	
    	
    	@Override	
    	public Test removeTest(int test_id) {
    		Test t=em.find(Test.class,test_id);
    		if(t!=null)
    			{em.remove(t);
    			}
            return t;
    	}
    	
    	@Override
		public Appointment approveAppointment(Appointment a) {
			Appointment aa=em.find(Appointment.class,a.getAppointment_id());
			if(aa!=null)
			{
				aa.setAppointment_status(a.getAppointment_status());
				aa.setDate_time(aa.getDate_time());
				
			}
			return aa;
		}
    	
    	


		public Userdata addUser(Userdata u) {
			Userdata e=em.merge(u);
			return e;
		}



		public Userdata updateUser(Userdata u) {
			Userdata e=em.find(Userdata.class,u.getUser_id());
			if(e!=null)
			{
				e.setUser_name(u.getUser_name());
				e.setPassword(u.getPassword());
				e.setGender(e.getGender());
				e.setContact_no(e.getContact_no());
				e.setAge(e.getAge());
				e.setUser_email(e.getUser_email());
			}
			return e;
		}



		public Userdata deleteUser(int user_id) {
			Userdata ud=em.find(Userdata.class,user_id);
			if(ud!=null)
				{em.remove(ud);
				}
	        return ud;
		}



		public Admindata addAdmin(Admindata a) {
			Admindata e=em.merge(a);
			return e;
		}
		}
		
		
 
              
            
        
        /*
    	@Override
    	public List<Userdata> getAllUsers() {
    		Query q=em.createQuery("select m from Userdata m");
    		List<Userdata> userlist=q.getResultList();
    		return userlist;
    	}
    	*/
	

		
		
		

