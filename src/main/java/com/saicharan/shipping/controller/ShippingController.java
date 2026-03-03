package com.saicharan.shipping.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.shipping.service.ShippingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shipping")
@RequiredArgsConstructor
public class ShippingController {
	
	private final ShippingService service;
	 
	@GetMapping("/calculate")
	public Map<String, Double> calculate(
			@RequestParam("warehouseId") Long warehouseId,
			@RequestParam("customerId") Long customerId,
			@RequestParam("productId") Long productId,
	        @RequestParam("deliveryType") String deliveryType){
		
		double charge = service.calculateShipping(warehouseId, customerId, productId, deliveryType);
		
		return Map.of("shippingCharge", charge);
	}

}
