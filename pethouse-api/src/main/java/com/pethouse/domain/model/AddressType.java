package com.pethouse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType {
	BILLING("Cobrança"),
	DELIVERY("Entrega");
	
	private final String description;

}
