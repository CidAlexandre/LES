package com.pethouse.api.strategy.customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.strategy.IStrategy;
import com.pethouse.api.utils.validators.Password;

@Service
public class CustomerConstraints implements IStrategy{

	@Override
	public String applyBusinessRule(DomainEntity domainEntity) {
		
		if(domainEntity instanceof Customer) {
			Customer c = (Customer) domainEntity;
			StringBuilder sb = new StringBuilder();
			
			Pattern pattern = Pattern.compile("/(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)|(^\\d{3}\\d{3}\\d{3}\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)|(^\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}$)/");
			Matcher matcher = pattern.matcher(c.getCpf());
			
			if(!matcher.matches()) sb.append("CPF inválido");
			sb.append(Password.validatePassword(c.getPassword(), c.getConfirmPassword()));
		
			return sb.toString();
		}
		
		return "";
	}

}
