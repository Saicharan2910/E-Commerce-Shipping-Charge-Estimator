package com.saicharan.shipping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saicharan.shipping.model.Customer;
import com.saicharan.shipping.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository repository;
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
	public List<Customer> getAll(){
		return repository.findAll();
	}
	
}
