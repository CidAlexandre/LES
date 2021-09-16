package com.pethouse.api.dto.address;

import com.pethouse.api.domain.model.Address;
import com.pethouse.api.dto.AttrResponseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDTO extends AttrResponseDTO {
	 private String street;
	 private String number;
	 private String neighborhood;
	 private String postalCode;
	 private String complement;
	 private String city;
	 private String state;
	 private Integer addressType;
	 
	 public AddressDTO(Address address) {
		 this.id = address.getId();
	     this.createdAt = address.getCreatedAt();
	     this.deletedAt = address.getDeletedAt();
	     this.street = address.getStreet();
	     this.number = address.getNumber();
	     this.neighborhood = address.getNeighborhood();
	     this.postalCode = address.getPostalCode();
	     this.complement = address.getComplement();
	     this.city = address.getCity();
	     this.state = address.getState();
	     this.addressType = address.getAddressType().ordinal();
	    }
}
