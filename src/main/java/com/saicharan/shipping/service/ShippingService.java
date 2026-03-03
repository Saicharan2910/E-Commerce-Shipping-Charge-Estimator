package com.saicharan.shipping.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.saicharan.shipping.enums.DeliveryType;
import com.saicharan.shipping.model.Customer;
import com.saicharan.shipping.model.Product;
import com.saicharan.shipping.model.Warehouse;
import com.saicharan.shipping.repository.CustomerRepository;
import com.saicharan.shipping.repository.ProductRepository;
import com.saicharan.shipping.repository.WarehouseRepository;
import com.saicharan.shipping.strategy.TransportStrategy;
import com.saicharan.shipping.strategy.TransportStrategyFactory;
import com.saicharan.shipping.util.DistanceUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShippingService {
	
	private final CustomerRepository customerRepo;
	
	private final WarehouseRepository warehouseRepo;
	
	private final ProductRepository productRepo;
	
	private final TransportStrategyFactory strategyFactory;
	
	@Cacheable("shippingCache")
	public double calculateShipping(Long warehouseId,
			                        Long customerId,
			                        Long productId,
			                        String deliveryTypeInput) { 
		
		System.out.println("Shipping calculation executed...");
		
		    Customer customer = customerRepo.findById(customerId)
	                .orElseThrow(() -> new RuntimeException("Customer not found"));

	        Warehouse warehouse = warehouseRepo.findById(warehouseId)
	                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

	        Product product = productRepo.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        DeliveryType deliveryType = DeliveryType.from(deliveryTypeInput);
	        
	        double distance = DistanceUtil.calculate(
	                warehouse.getLatitude(),
	                warehouse.getLongitude(),
	                customer.getLatitude(),
	                customer.getLongitude());
	
	        TransportStrategy strategy = strategyFactory.getStrategy(distance);
	        
	        double rate = strategy.getRate();

	        double shippingCharge = distance * product.getWeight() * rate;

	        shippingCharge += 10; // base charge
	        
	        if (deliveryType == DeliveryType.EXPRESS) {
	            shippingCharge += 20; // express extra charge
	        }

	        return Math.round(shippingCharge * 100.0) / 100.0;
	    }
}
