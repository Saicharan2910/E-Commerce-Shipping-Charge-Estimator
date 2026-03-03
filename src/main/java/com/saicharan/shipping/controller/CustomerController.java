package com.saicharan.shipping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.shipping.model.Customer;
import com.saicharan.shipping.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService service;
		
	@PostMapping
	public Customer create(@RequestBody Customer customer) {
		return service.save(customer);
	}
	
	@GetMapping
	public List<Customer> getAll(){
		return service.getAll();
	}
	 
}
