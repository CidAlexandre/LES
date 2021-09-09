package com.pethouse.api.dao.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pethouse.api.dao.IDAO;
import com.pethouse.domain.model.DomainEntity;
import com.pethouse.domain.repository.ICustomerRepository;

public class CustomerDAO implements IDAO{

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public DomainEntity create(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainEntity delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainEntity update(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomainEntity> list(DomainEntity domainEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainEntity get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
