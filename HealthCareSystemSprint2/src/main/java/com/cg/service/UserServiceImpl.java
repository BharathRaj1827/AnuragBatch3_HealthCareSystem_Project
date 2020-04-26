package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Users;
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
     public Users viewUser(int userid)
     {
    	 return udao.findById(userid).get();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#viewUser()
	 */
    @Override
	@Transactional(readOnly=true)
     public List<Users> viewUser()
     {
    	 return udao.findAll();
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#addUser(com.cg.bean.Userdata)
	 */
    @Override
	@Transactional
     public Users addUser(Users user)
     {
    	 return udao.save(user);
     }
     
     /* (non-Javadoc)
	 * @see com.cg.service.UserService#updateUser(com.cg.bean.Userdata)
	 */
    @Override
	@Transactional
     public Users updateUser(Users u)
     {
    		Users ud=udao.findById(u.getUserid()).get();
    		if(ud!=null)
    		{
    			ud.setName(u.getName());
    			ud.setPassword(u.getPassword());
    			ud.setPhonenumber(u.getPhonenumber());
    			ud.setEmail(u.getEmail());
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
     public void deleteUser(int userid)
     {
    	  udao.deleteById(userid);
     }
    
    
    
    
}
