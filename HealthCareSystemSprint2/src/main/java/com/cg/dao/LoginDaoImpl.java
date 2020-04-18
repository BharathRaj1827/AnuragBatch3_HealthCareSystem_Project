package com.cg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.cg.entity.Userdata;

@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Userdata addUser(Userdata u) {
		// TODO Auto-generated method stub
		Userdata e=em.merge(u);
		return e;
	}
	
	
	@Override
	public List<Userdata> getAllUsers() {
		Query q=em.createQuery("select m from Userdata m");
		List<Userdata> userlist=q.getResultList();
		return userlist;
	}
	
	@Override
	public Userdata updateUser(Userdata u) {
		Userdata ud=em.find(Userdata.class,u.getUserId());
		if(ud!=null)
		{

			ud.setUserName(u.getUserName());
			ud.setUserType(u.getUserType());
			ud.setUserPassword(u.getUserPassword());
			ud.setUserPhoneno(u.getUserPhoneno());
			ud.setUserEmail(u.getUserEmail());
		}
		return ud;
			
	}
	@Override	
	public Userdata deleteUser(int userId) {
		Userdata ud=em.find(Userdata.class,userId);
		if(ud!=null)
			{em.remove(ud);
			}
        return ud;
	}
	
	@Override
	public Boolean loginUser(Userdata u) {
	Query q=em.createQuery("select m from Userdata m where m.userName=?1 and m.userPassword=?2");
	String a=u.getUserName();
	String b=u.getUserPassword();
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


	@Override
	public Boolean adminLoginUser(Userdata u) {
		String a=u.getUserName();
		String b=u.getUserPassword();
		Query q=em.createQuery("select m.userType from Users m where m.userName=?1 and m.userPassword=?2");
		q.setParameter(1, a);
		q.setParameter(2,b);
		Object result = q.getSingleResult();
		String userType=result.toString();
		boolean flag=false;
		if(userType.contentEquals("capgemini"))
		{
	Query q1=em.createQuery("select m from Users m where m.userName=?1 and m.userPassword=?2");
	q1.setParameter(1, a);
	q1.setParameter(2,b);
	try
	{
		Object m=q.getSingleResult();
		flag=true;
	}catch(javax.persistence.NoResultException e)
    {
        e.printStackTrace();
    }}
	return flag;
	}
	
}
