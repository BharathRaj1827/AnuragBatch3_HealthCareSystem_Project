package com.cg.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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
			// TODO Auto-generated method stub
			Appointment at=em.merge(a);
			return at;
			
		}



		@Override
		public List<Diagnostic_center> getAllCenters() {
			// TODO Auto-generated method stub
			Query q=em.createQuery("select m from Diagnostic_center m");
    		List<Diagnostic_center> centerlist=q.getResultList();
    		return centerlist;
			
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

