package com.vadantu.app.dao;

import com.vadantu.app.model.Account;

public interface CustomerDao {

	Account findBy(String username);
	Long save(Account customer);
	
}
