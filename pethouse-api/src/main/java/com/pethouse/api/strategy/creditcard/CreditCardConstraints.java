package com.pethouse.api.strategy.creditcard;

import org.springframework.stereotype.Service;

import com.pethouse.api.domain.model.CreditCard;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.strategy.IStrategy;

@Service
public class CreditCardConstraints implements IStrategy{

	@Override
	public String applyBusinessRule(DomainEntity domainEntity) {
		StringBuilder stringBuilder = new StringBuilder();
		
		if(domainEntity instanceof CreditCard) {
			CreditCard creditCard = (CreditCard) domainEntity;
			
			if(creditCard.getCreditCardNumber().trim().length() < 13) {
				stringBuilder.append("Cartão inválido");
			}
		}
		return stringBuilder.toString();
	}

}
