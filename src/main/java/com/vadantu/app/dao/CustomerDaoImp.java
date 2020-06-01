package com.vadantu.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vadantu.app.model.Account;

@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account findBy(String username) {
		String queryString = "FROM Customer WHERE username = :username";
		return (Account) sessionFactory.getCurrentSession()
								.createQuery(queryString)
								.setParameter("username", username)
								.uniqueResult();
	}

	@Override
	public Long save(Account customer) {
		return (Long) sessionFactory.getCurrentSession().save(customer);		
	}

}
