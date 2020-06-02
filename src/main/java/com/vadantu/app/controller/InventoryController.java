package com.vadantu.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vadantu.app.exception.InventoryNotFoundException;
import com.vadantu.app.model.Inventory;
import com.vadantu.app.service.InventoryService;


@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Inventory>> getInventory() throws InventoryNotFoundException {
		List<Inventory> inventory = inventoryService.findAll();
		return new ResponseEntity<List<Inventory>> (inventory, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/inventory/{idinventory}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Inventory> getBy(@PathVariable("idInventory") Long idInventory) throws InventoryNotFoundException  {
		Inventory inventory = inventoryService.findBy(idInventory);
		return new ResponseEntity<Inventory> (inventory, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventory?description={description}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Inventory> getByDescription(@PathVariable("description") String description) throws InventoryNotFoundException  {
		Inventory inventory = inventoryService.findBy(description);
		return new ResponseEntity<Inventory> (inventory, HttpStatus.OK);
	}
}
