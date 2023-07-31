package com.ecommerce.Digicart.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.Digicart.Model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Product product) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int i = (int) session.save(product);
		transaction.commit();
		if(i != 0) {
			result = true;
		}
		return result;
	}

	@Override
	public List<Product> list() {
		Session session = sessionFactory.openSession();
		List<Product> list = session.createQuery("from Product").list();
		return list;
	}

	@Override
	public boolean update(Product product) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		if(product != null) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean delete(Product delete) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			 session.remove(session.merge(delete));
			 transaction.commit();
			 result = true;
			 
		} catch (Exception e) {
			System.out.println(e);
			result = false;
		}
		
		return result;
	}

}
