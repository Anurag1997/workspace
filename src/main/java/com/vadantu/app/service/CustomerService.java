package com.vadantu.app.service;

import java.security.NoSuchAlgorithmException;

import com.vadantu.app.exception.AuthenticationFailedException;
import com.vadantu.app.model.Account;

public interface CustomerService {

	Account authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Account customer) throws NoSuchAlgorithmException;
}
