package com.pethouse.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pethouse.api.facade.Facade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("/credit-cards")
public class CreditCardController {

	private Facade facade;
}
