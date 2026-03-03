package com.saicharan.shipping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saicharan.shipping.model.Product;
import com.saicharan.shipping.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;
	
	public Product save(Product product) {
		return repository.save(product);
	}
	
	public List<Product> getAll(){
		return repository.findAll();
	}

}
