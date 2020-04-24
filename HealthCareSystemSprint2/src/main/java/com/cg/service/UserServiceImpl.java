package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Userdata;
import com.cg.dao.UserRepository;


@Service
public class UserServiceImpl implements UserService
{
     @Autowired
     UserRepository udao;
 

	/* (non-Javadoc)
	 * @see com.cg.service.UserService#setUdao(com.cg.dao.UserRepository)
	 */
	@Override
	public void setUdao(UserRepository udao) { this.udao=udao; }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#viewUser(int)
	 */
    @Override
	@Transactional(readOnly=true)
     public Userdata viewUser(int userid)
     {
    	 return udao.findById(userid).get();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#viewUser()
	 */
    @Override
	@Transactional(readOnly=true)
     public List<Userdata> viewUser()
     {
    	 return udao.findAll();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#addUser(com.cg.bean.Userdata)
	 */
    @Override
	@Transactional
     public Userdata addUser(Userdata user)
     {
    	 return udao.save(user);
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#updateUser(com.cg.bean.Userdata)
	 */
    @Override
	@Transactional
     public Userdata updateUser(Userdata u)
     {
    		Userdata ud=udao.findById(u.getUser_id()).get();
    		if(ud!=null)
    		{
    			ud.setUser_name(u.getUser_name());
    			ud.setPassword(u.getPassword());
    			ud.setContact_no(u.getContact_no());
    			ud.setUser_email(u.getUser_email());
    			ud.setGender(u.getGender());
    			ud.setAge(u.getAge());
    		}
    		return udao.save(ud);
    	 
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#deleteUser(int)
	 */
    @Override
	@Transactional
     public void deleteUser(int user_id)
     {
    	  udao.deleteById(user_id);
     }
}
