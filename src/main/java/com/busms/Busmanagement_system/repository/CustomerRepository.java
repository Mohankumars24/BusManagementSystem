package com.busms.Busmanagement_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busms.Busmanagement_system.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmail(String email);

	boolean existsByPhone(long mobile);

	Customer findByPhone(long mobile);

	Customer findByEmail(String email);
}
