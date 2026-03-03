package com.saicharan.shipping.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.saicharan.shipping.model.Customer;
import com.saicharan.shipping.model.Product;
import com.saicharan.shipping.model.Warehouse;
import com.saicharan.shipping.repository.CustomerRepository;
import com.saicharan.shipping.repository.ProductRepository;
import com.saicharan.shipping.repository.WarehouseRepository;
import com.saicharan.shipping.strategy.TransportStrategy;
import com.saicharan.shipping.strategy.TransportStrategyFactory;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceTest {

	@Mock
	private CustomerRepository customerRepo;
	
	@Mock
	private WarehouseRepository warehouseRepo;
	
	@Mock
	private ProductRepository productRepo;
	
	@Mock
	private TransportStrategyFactory strategyFactory;
	
	@Mock
	private TransportStrategy strategy;
	
	@InjectMocks
	private ShippingService shippingService;
	
	@Test
	void testCalulateShipping() {
		
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setLatitude(12.0);
		customer.setLongitude(77.0);
		
		Warehouse warehouse = new Warehouse();
		warehouse.setId(101L);
		warehouse.setLatitude(13.0);
		warehouse.setLongitude(78.0);
		
		Product product = new Product();
		product.setId(201L);
		product.setWeight(2.0);
		
		when(customerRepo.findById(1L)).thenReturn(Optional.of(customer));
		when(warehouseRepo.findById(101L)).thenReturn(Optional.of(warehouse));
        when(productRepo.findById(201L)).thenReturn(Optional.of(product));
        when(strategyFactory.getStrategy(anyDouble())).thenReturn(strategy);
        when(strategy.getRate()).thenReturn(2.0);

        double result = shippingService.calculateShipping(
                101L, 1L, 201L, "STANDARD");

        assertTrue(result > 0);
	}
	
}
