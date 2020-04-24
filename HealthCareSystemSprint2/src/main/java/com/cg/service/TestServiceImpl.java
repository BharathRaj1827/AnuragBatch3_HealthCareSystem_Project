package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Test;
import com.cg.dao.TestRepository;

@Service
public class TestServiceImpl implements TestService
{
     @Autowired
     TestRepository udao;
 

	/* (non-Javadoc)
	 * @see com.cg.service.TestService#setUdao(com.cg.dao.TestRepository)
	 */
	@Override
	public void setUdao(TestRepository udao) { this.udao=udao; }
    
	/*
     @Transactional(readOnly=true)
     public Test viewUser(int userid)
     {
    	 return udao.findById(userid).get();
     }*/
     
     /* (non-Javadoc)
	 * @see com.cg.service.TestService#viewTest()
	 */
    @Override
	@Transactional(readOnly=true)
     public List<Test> viewTest()
     {
    	 return udao.findAll();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.TestService#addTest(com.cg.bean.Test)
	 */
    @Override
	@Transactional
     public Test addTest(Test test)
     {
    	 return udao.save(test);
     }
     
     /*
     @Transactional
     public Test updateTest(Test u)
     {
    		Userdata ud=udao.findById(u.getUserid()).get();
    		if(ud!=null)
    		{
    			ud.setUsername(u.getUsername());
    			ud.setUserpassword(u.getUserpassword());
    			ud.setUserphone(u.getUserphone());
    			ud.setUseremail(u.getUseremail());
    		}
    		return udao.save(ud);
     }*/
     
     
     
     /* (non-Javadoc)
	 * @see com.cg.service.TestService#removeTest(int)
	 */
    @Override
	@Transactional
     public void removeTest(int test_id)
     {
    	  udao.deleteById(test_id);
     }
}