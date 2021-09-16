package com.pethouse.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pethouse.api.domain.model.Address;
import com.pethouse.api.facade.Facade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
	
	private Facade facade;
	
	@GetMapping
	public ResponseEntity getAllAddress() {
		return ResponseEntity.ok(facade.list(new Address()));
	}
	
	@GetMapping("/{$id}")
	public ResponseEntity getAddress(@PathVariable Long id) {
		Address address = new Address();
		address.setId(id);
		return ResponseEntity.ok(facade.get(address));
	}
	
	@PutMapping
	public ResponseEntity updateAddress(@RequestBody Address address) {
		return ResponseEntity.ok(facade.update(address));
	}
	
	@DeleteMapping("{$id}")
	public ResponseEntity deleteAddress(@PathVariable Long id) {
		Address address = new Address();
		address.setId(id);
		return ResponseEntity.ok(facade.delete(address));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity newAddress(@RequestBody Address address) {
		return ResponseEntity.ok(facade.create(address));
	}
}
