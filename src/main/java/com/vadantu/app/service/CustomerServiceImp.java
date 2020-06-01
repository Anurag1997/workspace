package com.vadantu.app.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vadantu.app.dao.CustomerDao;
import com.vadantu.app.exception.AuthenticationFailedException;
import com.vadantu.app.model.Account;
import com.vadantu.app.util.ShaHashing;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Account authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		Account customer = customerDao.findBy(username);
		if(customer.getPassword().equals(ShaHashing.encrypted(password)))
			return customer;
		else
			throw new AuthenticationFailedException();
	}

	@Override
	public Long addCustomer(Account customer) throws NoSuchAlgorithmException {
		customer.setPassword(ShaHashing.encrypted(customer.getPassword()));
		return customerDao.save(customer);
	}

}
