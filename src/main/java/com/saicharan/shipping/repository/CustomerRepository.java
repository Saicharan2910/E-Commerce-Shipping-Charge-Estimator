package com.saicharan.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saicharan.shipping.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
}
