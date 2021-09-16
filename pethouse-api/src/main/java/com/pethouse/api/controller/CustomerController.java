package com.pethouse.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.facade.Facade;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private Facade facade;
	
	@GetMapping
	public ResponseEntity getAllCustomer(){
		return ResponseEntity.ok(facade.list(new Customer()));
    }
	
	@GetMapping("/{$id}")
	public ResponseEntity getCustomer(@PathVariable Long id){
		Customer customer = new Customer();
		customer.setId(id);
		return ResponseEntity.ok(facade.get(customer));
	}

	@CrossOrigin(origins = "*")
	@PutMapping
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(facade.update(customer));
	}
	
	@PatchMapping
	public ResponseEntity updateCustomerPassword(@RequestBody Customer customer) {
		return ResponseEntity.ok(facade.updatePassword(customer));
	}
	
	@DeleteMapping("/{$id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		Customer customer = new Customer();
		customer.setId(id);
		
		return ResponseEntity.ok(facade.delete(customer));
	}
	
	@PostMapping
	public ResponseEntity newCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(facade.create(customer));
	}
}