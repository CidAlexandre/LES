package com.pethouse.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "customer")
public class Customer extends DomainEntity{
	
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String cpf;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime birthDate;
	
	private String phone;
	
	private String typePhone;
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Transient
	private String newPassword;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Address> address;
	

}
