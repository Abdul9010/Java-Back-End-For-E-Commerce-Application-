package com.ecommerce.Digicart.Dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.Digicart.Model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean register(UserModel user) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = (int) session.save(user);
		transaction.commit();
		if( id != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public boolean login(UserModel user) {
		
		boolean result = false;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String HQLQuery = "select password from UserModel where username=:username";
		Query query = session.createQuery(HQLQuery);
		query.setParameter("username", user.getUsername());
		transaction.commit();
		
		String pass = query.getSingleResult().toString();
			if(user.getPassword().contentEquals(pass)) {
				result = true;
		
			}
		return result;
	}
	
}
