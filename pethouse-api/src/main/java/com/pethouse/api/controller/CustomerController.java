package com.pethouse.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pethouse.domain.model.Customer;
import com.pethouse.domain.repository.ICustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	private ICustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> listAll(){
		return customerRepository.findAll();
    }
	
	@GetMapping("/{$customerId}")
	public ResponseEntity<Customer> search(@PathVariable Long customerId){
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			return ResponseEntity.ok(customer.get());
		}
		 return ResponseEntity.notFound().build();
			
			/*
			 return customerRepository.findById(customerId)
			 	.map(ResponseEntity::ok)
			 	.orElse(ResponseEntity.notFound().build());
			 */
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}