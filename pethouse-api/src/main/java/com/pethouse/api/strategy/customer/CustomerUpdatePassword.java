package com.pethouse.api.strategy.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pethouse.api.dao.customer.CustomerDAO;
import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.strategy.IStrategy;

@Service
public class CustomerUpdatePassword implements IStrategy{

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public String applyBusinessRule(DomainEntity domainEntity) {
		if(domainEntity instanceof Customer) {
			Customer customer = (Customer) domainEntity;
			StringBuilder sb = new StringBuilder();
			
			Customer customerExisting = (Customer) customerDAO.get(domainEntity.getId());
			
			String encrypted = customerExisting.getPassword();
		
			if(encoder.matches(customer.getNewPassword(), encrypted)) {
				sb.append("A nova senha não pode ser igual a anterior.");
				return sb.toString();
			}
			
			if(!encoder.matches(customer.getPassword(), encrypted)) {
				sb.append("Senha incorreta");
				return sb.toString();
			}
			
			return sb.toString();
		}
		
		return null;
	}

}
