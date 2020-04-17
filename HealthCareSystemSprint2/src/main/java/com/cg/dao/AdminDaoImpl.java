package com.cg.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entity.Diagnostic_center;
import com.cg.entity.Test;


@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Diagnostic_center addCenter(Diagnostic_center d) {
		// TODO Auto-generated method stub
		Diagnostic_center e=em.merge(d);
		return e;
	}
	
	
	
	@Override	
	public Diagnostic_center removeCenter(int centerId) {
		Diagnostic_center d=em.find(Diagnostic_center.class,centerId);
		if(d!=null)
			{em.remove(d);
			}
        return d;
	}
        
        @Override
    	public Test addTest(Test t) {
    		// TODO Auto-generated method stub
    		Test e=em.merge(t);
    		return e;
    	}
    	
    	
    	
    	@Override	
    	public Test removeTest(int testId) {
    		Test t=em.find(Test.class,testId);
    		if(t!=null)
    			{em.remove(t);
    			}
            return t;
            
        
        
        
        
            
        
        /*
    	@Override
    	public List<Userdata> getAllUsers() {
    		Query q=em.createQuery("select m from Userdata m");
    		List<Userdata> userlist=q.getResultList();
    		return userlist;
    	}
    	*/
	}
}
