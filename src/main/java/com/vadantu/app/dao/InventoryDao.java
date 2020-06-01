package com.vadantu.app.dao;

import java.util.List;

import com.vadantu.app.model.Inventory;

public interface InventoryDao {

	Inventory findBy(Long idinventory);
	Inventory findBy(String description);
	List<Inventory> findByCategory(String category);
	List<Inventory> findAll();
	
}
