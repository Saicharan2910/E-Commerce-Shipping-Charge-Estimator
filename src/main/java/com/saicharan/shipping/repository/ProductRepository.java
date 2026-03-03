package com.saicharan.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saicharan.shipping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
