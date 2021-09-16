package com.pethouse.api.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "customer")
@Where(clause = "detele_at is null")
public class Customer extends DomainEntity{
	
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String cpf;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private String phone;
	
	private String typePhone;
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Transient
	private String newPassword;
	
	@OneToMany(fetch = FetchType.LAZY, 
				cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, 
				mappedBy = "customer", targetEntity = Address.class)
	private List<Address> address;
	
	@OneToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
				mappedBy = "customer", targetEntity = CreditCard.class)
	private List<CreditCard> card;
	

}
