package com.pethouse.api.dto.customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.dto.AttrResponseDTO;
import com.pethouse.api.dto.address.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO extends AttrResponseDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	private String phone;
	private String typePhone;
	private List<AddressDTO> address;

	public CustomerDTO(Customer customer, String method) {
		this.id = customer.getId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		this.cpf = customer.getCpf();
		this.birthDate = customer.getBirthDate();
		this.phone = customer.getPhone();
		this.typePhone = customer.getTypePhone();
		
		if(method.equals("GET")) {
			customer.getAddress().forEach(a -> address.add(new AddressDTO(a)));
		}
	}
}
