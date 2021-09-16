package com.pethouse.api.dto.creditcard;

import com.pethouse.api.domain.model.CreditCard;
import com.pethouse.api.dto.AttrResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCardDTO extends AttrResponseDTO{

	private String creditCardNumber;
	private String cardHolder;
	private String cardMonth;
	private String cardYear;
	private String cardSecurity;
	private String cardFlag;
	private String cardFavourite;

	public CreditCardDTO(CreditCard creditCard, String method) {
		this.id = creditCard.getId();
		this.creditCardNumber = creditCard.getCreditCardNumber();
		this.cardHolder = creditCard.getCardHolder();
		this.cardMonth = creditCard.getCardMonth();
		this.cardYear = creditCard.getCardYear();
		this.cardSecurity = creditCard.getCardSecurity();
		this.cardFlag = creditCard.getCardFlag();
		this.cardFavourite = creditCard.getCardFavourite();
	}
}
