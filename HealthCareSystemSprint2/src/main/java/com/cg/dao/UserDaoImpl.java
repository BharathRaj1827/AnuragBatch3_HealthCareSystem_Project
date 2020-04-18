package com.cg.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entity.Appointment;
import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;


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
}
