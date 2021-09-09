package com.pethouse.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pethouse.domain.model.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByFirstName(String firstName);
}
