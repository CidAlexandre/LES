package com.pethouse.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "address")
public class Address extends DomainEntity {

	private String street;
	
	private String number;
	
	private String complement;
	
	private String neighborhood;
	
	private String postalCode;
	
	private String city;
	
	private String state;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	
	@ManyToOne
	private Customer customer;
	
}
