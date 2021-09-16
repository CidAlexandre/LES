package com.pethouse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethouse.api.domain.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
