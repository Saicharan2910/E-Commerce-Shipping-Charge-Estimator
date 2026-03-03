package com.saicharan.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ECommerceshippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceshippingApplication.class, args);
	}

}
