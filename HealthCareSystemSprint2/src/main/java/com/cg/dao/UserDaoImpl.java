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
public class UserDaoImpl implements UserDao {

	@PersistenceContext	
	 EntityManager em;

		@Override
		public Appointment makeAppointment(Appointment a) {
			Appointment at=em.merge(a);
			return at;
			
		}



		@Override
		public List<Diagnostic_center> getAllCenters() {
			Query q=em.createQuery("select m from Diagnostic_center m");
    		List<Diagnostic_center> centerlist=q.getResultList();
    		return centerlist;
			
		}
		
		
		public List<Test> getAllTests(int center_id) {
			Query q=em.createQuery("select *from Test where center_id=?1");
    		List<Test> testlist=q.getResultList();
    		return testlist;
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


    	
    	
		
		@Override
		public boolean loginUser(Userdata u) {
		
			Query q=em.createQuery("select m from User m where m.user_name=?1 and m.password=?2");
			String a=u.getUser_name();
			String b=u.getPassword();
			q.setParameter(1, a);
			q.setParameter(2,b);
			try
			{
				Userdata m=(Userdata) q.getSingleResult();
				return true;
			}catch(javax.persistence.NoResultException e)
		    {
		        e.printStackTrace();
		    }
			return false;
			}
		}

