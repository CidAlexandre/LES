package com.pethouse.api.strategy.address;

import org.springframework.stereotype.Service;

import com.pethouse.api.domain.model.Address;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.strategy.IStrategy;

@Service
public class AddressConstraints implements IStrategy{

	@Override
	public String applyBusinessRule(DomainEntity domainEntity) {
		StringBuilder sb = new StringBuilder();
		
		if(domainEntity instanceof Address) {
			Address a = (Address) domainEntity;
			
			if(a.getPostalCode().trim().length() != 8) {
				sb.append("CEP inválido");
			}
		}
		return sb.toString();
	}

}
