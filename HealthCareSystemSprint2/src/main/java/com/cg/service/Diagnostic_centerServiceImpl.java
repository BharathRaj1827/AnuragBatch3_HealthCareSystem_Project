package com.cg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Diagnostic_center;
import com.cg.dao.Diagnostic_centerRepository;

@Service
public class Diagnostic_centerServiceImpl implements Diagnostic_centerService
{
     @Autowired
     Diagnostic_centerRepository udao;
 

	/* (non-Javadoc)
	 * @see com.cg.service.Diagnostic_centerService#setUdao(com.cg.dao.Diagnostic_centerRepository)
	 */
	@Override
	public void setUdao(Diagnostic_centerRepository udao) { this.udao=udao; }
    
	/*
     @Transactional(readOnly=true)
     public Test viewUser(int userid)
     {
    	 return udao.findById(userid).get();
     }*/
     
     /* (non-Javadoc)
	 * @see com.cg.service.Diagnostic_centerService#viewDiagnostic_center()
	 */
    @Override
	@Transactional(readOnly=true)
     public List<Diagnostic_center> viewDiagnostic_center()
     {
    	 return udao.findAll();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.Diagnostic_centerService#addCenter(com.cg.bean.Diagnostic_center)
	 */
    @Override
	@Transactional
     public Diagnostic_center addCenter(Diagnostic_center center )
     {
    	 return udao.save(center);
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
	 * @see com.cg.service.Diagnostic_centerService#removeCenter(int)
	 */
    @Override
	@Transactional
     public void removeCenter(int center_id)
     {
    	  udao.deleteById(center_id);
     }
}