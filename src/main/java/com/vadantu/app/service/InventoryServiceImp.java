package com.vadantu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vadantu.app.dao.InventoryDao;
import com.vadantu.app.exception.InventoryNotFoundException;
import com.vadantu.app.model.Inventory;

@Service
@Transactional
public class InventoryServiceImp implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;

	@Override
	public Inventory findBy(Long idInventory) throws InventoryNotFoundException {
		Inventory product = inventoryDao.findBy(idInventory);
		if (product != null)
			return product;
		else
			throw new InventoryNotFoundException();
	}

	@Override
	public Inventory findBy(String description) throws InventoryNotFoundException {
		Inventory inventory = inventoryDao.findBy(description);
		if (inventory != null)
			return inventory;
		else
			throw new InventoryNotFoundException();
	}



	@Override
	public List<Inventory> findAll() throws InventoryNotFoundException {
		List<Inventory> inventory = inventoryDao.findAll();
		if (inventory.isEmpty() || inventory == null)
			throw new InventoryNotFoundException();
		else
			return inventory;
	}

}
