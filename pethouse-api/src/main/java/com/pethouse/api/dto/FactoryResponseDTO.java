package com.pethouse.api.dto;

import com.pethouse.api.domain.model.Address;
import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.dto.address.AddressDTO;
import com.pethouse.api.dto.customer.CustomerDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class FactoryResponseDTO {
	public static boolean hasError;
	public static String message;
	
	public static AttrResponseDTO createDTO(DomainEntity domainEntity, String method) {
		if(hasError) {
			return new ErrorDTO(message);
		}
		
		if(domainEntity instanceof Customer) {
			return new CustomerDTO((Customer) domainEntity, method);
		}
		
		if(domainEntity instanceof Address) {
			return new AddressDTO((Address) domainEntity);
		}
		
		
		return null;
	}
}
