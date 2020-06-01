package com.vadantu.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Inventory not found")
public class InventoryNotFoundException extends Exception {
	
	public InventoryNotFoundException() {
		super();
	}

	public InventoryNotFoundException(String message) {
		super(message);
	}

}
