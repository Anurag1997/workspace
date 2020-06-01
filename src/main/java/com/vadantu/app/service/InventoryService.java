package com.vadantu.app.service;

import java.util.List;

import com.vadantu.app.exception.InventoryNotFoundException;
import com.vadantu.app.model.Inventory;

public interface InventoryService {

	Inventory findBy(Long idInventory) throws InventoryNotFoundException;
	Inventory findBy(String description) throws InventoryNotFoundException;
	List<Inventory> findByCategory(String category) throws InventoryNotFoundException;
	List<Inventory> findAll() throws InventoryNotFoundException;
	
}
