package com.pethouse.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethouse.domain.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
