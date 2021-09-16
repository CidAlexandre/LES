package com.pethouse.api.dao.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pethouse.api.dao.IDAO;
import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.repository.ICustomerRepository;
import com.pethouse.api.utils.FillNullProperty;

@Service
public class CustomerDAO implements IDAO{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public DomainEntity create(DomainEntity domainEntity) {
		Customer customer = (Customer) domainEntity;
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		customerRepository.saveAndFlush(customer);
		
		return customer;
	}

	@Override
	public DomainEntity delete(Long id) {
		Customer customer = (Customer) get(id);
		customer.setDeletedAt(LocalDateTime.now());
		
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public DomainEntity update(DomainEntity domainEntity) {
		//https://stackoverflow.com/questions/27818334/jpa-update-only-specific-fields
		Customer customerNew = (Customer) domainEntity;
		Customer customerExisting = (Customer) get(domainEntity.getId());
		String cpf = customerExisting.getCpf();
		LocalDateTime createdAt = customerExisting.getCreatedAt();
		String encrypted = customerExisting.getPassword();
		
		FillNullProperty.copyNonNullProperties(customerNew, customerExisting);
		
		customerExisting.setCpf(cpf);
		customerExisting.setCreatedAt(createdAt);
		customerExisting.setPassword(encrypted);
		customerExisting.setUpdatedAt(LocalDateTime.now());
		
		if(null != customerNew.getNewPassword()) {
			customerExisting.setPassword(
					passwordEncoder
					.encode(customerNew.getNewPassword()));
		}
		
		return customerRepository.saveAndFlush(customerExisting);
	}

	@Override
	public List<DomainEntity> list(DomainEntity domainEntity) {
		List<DomainEntity> domains = new ArrayList<>();
		customerRepository.findAll().forEach(c -> domains.add(c));
		
		return domains;
	}

	@Override
	public DomainEntity get(Long id) {
		Customer customer = null;
		try {
			customer = customerRepository.findById(id).get();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}
	
	
}
