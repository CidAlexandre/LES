package com.pethouse.api.dao.creditcard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethouse.api.dao.IDAO;
import com.pethouse.api.domain.model.CreditCard;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.repository.ICreditCardRepository;
import com.pethouse.api.utils.FillNullProperty;

@Service
public class CreditCardDAO implements IDAO{
	
	@Autowired
	ICreditCardRepository creditCardRepository;

	@Override
	public DomainEntity create(DomainEntity domainEntity) {
		CreditCard card = (CreditCard) domainEntity;
		
		return creditCardRepository.saveAndFlush(card);
	}

	@Override
	public DomainEntity delete(Long id) {
		CreditCard card = (CreditCard) get(id);
		card.setDeletedAt(LocalDateTime.now());
		
		creditCardRepository.saveAndFlush(card);
		return card;
	}

	@Override
	public DomainEntity update(DomainEntity domainEntity) {
		CreditCard cardNew = (CreditCard) domainEntity;
		CreditCard cardExisting = (CreditCard) get(domainEntity.getId());
		
		LocalDateTime createdAt = LocalDateTime.now();
		
		FillNullProperty.copyNonNullProperties(cardNew, cardExisting);
		
		cardExisting.setCreatedAt(createdAt);
		cardExisting.setUpdatedAt(LocalDateTime.now());
		
		return creditCardRepository.saveAndFlush(cardExisting);
	}

	@Override
	public List<DomainEntity> list(DomainEntity domainEntity) {
		List<DomainEntity> domains = new ArrayList<>();
		creditCardRepository.findAll().forEach(cc -> domains.add(cc));
		return domains;
	}

	@Override
	public DomainEntity get(Long id) {
		CreditCard card = null;
		try {
			card = creditCardRepository.findById(id).get();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return card;
	}

}
