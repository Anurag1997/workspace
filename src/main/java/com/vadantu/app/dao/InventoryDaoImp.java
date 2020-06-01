package com.vadantu.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vadantu.app.model.Inventory;

@Repository
public class InventoryDaoImp implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }
	
	@Override
	public Inventory findBy(Long idInventory) {
		String queryString = "SELECT p FROM Product AS p WHERE p.idProduct = :idProduct";
		return (Inventory) getSession().createQuery(queryString)
								.setParameter("idProduct", idInventory)
								.uniqueResult();
	}

	@Override
	public Inventory findBy(String description) {
		String queryString = "SELECT p FROM Product AS p WHERE p.description = :description";
		return (Inventory) getSession().createQuery(queryString)
								.setParameter("description", description)
								.uniqueResult();
	}
	
	@Override
	public List<Inventory> findByCategory(String category) {
		String queryString = "SELECT p FROM Product AS p WHERE p.category.description = :category";
		return getSession().createQuery(queryString)
					.setParameter("category", category)
					.list();
	}

	@Override
	public List<Inventory> findAll() {
		String queryString = "SELECT p FROM Product AS p";
		return getSession().createQuery(queryString)
					.list();
	}

}
