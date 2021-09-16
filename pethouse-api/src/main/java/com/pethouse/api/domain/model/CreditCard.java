package com.pethouse.api.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="credit_card")
@Where(clause = "delete_at is null")
public class CreditCard extends DomainEntity{
	
	private String creditCardNumber;
	
	private String cardHolder;
	
	private String cardMonth;
	
	private String cardYear;
	
	private String cardSecurity;
	
	private String cardFlag;
	
	private String cardFavourite;
	
	@ManyToOne
	private Customer customer;
}
