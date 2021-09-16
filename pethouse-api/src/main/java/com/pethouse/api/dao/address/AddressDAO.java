package com.pethouse.api.dao.address;

import com.pethouse.api.dao.IDAO;
import com.pethouse.api.domain.model.Address;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.repository.IAddressRepository;
import com.pethouse.api.utils.FillNullProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressDAO implements IDAO {

    @Autowired
    IAddressRepository addressRepository;

    @Override
    public DomainEntity create(DomainEntity domainEntity) {
    	Address address = (Address) domainEntity;
    	
    	return addressRepository.saveAndFlush(address);
    }

    @Override
    public DomainEntity delete(Long id) {
        Address address = (Address) get(id);
        address.setDeletedAt(LocalDateTime.now());
        
        addressRepository.saveAndFlush(address);
    	return address;
    }

    @Override
    public DomainEntity update(DomainEntity domainEntity) {
        Address addressNew = (Address) domainEntity;
        Address addressExisting = (Address) get(domainEntity.getId());
        
        LocalDateTime createdAt = LocalDateTime.now();
        
        FillNullProperty.copyNonNullProperties(addressNew, addressExisting);
        
        addressExisting.setCreatedAt(createdAt);
        addressExisting.setUpdatedAt(LocalDateTime.now());
        
    	return addressRepository.saveAndFlush(addressExisting);
    }

    @Override
    public List<DomainEntity> list(DomainEntity domainEntity) {
    	List<DomainEntity> domains = new ArrayList<>();
    	
    	addressRepository.findAll().forEach(a -> domains.add(a));
    	
        return domains;
    }

    @Override
    public DomainEntity get(Long id) {
    	Address address = null;
    	try {
    		address = addressRepository.findById(id).get();
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
        return address;
    }
}
