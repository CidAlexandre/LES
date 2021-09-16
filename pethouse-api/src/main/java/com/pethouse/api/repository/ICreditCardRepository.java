package com.pethouse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethouse.api.domain.model.CreditCard;

public interface ICreditCardRepository extends JpaRepository<CreditCard, Long>{

}
