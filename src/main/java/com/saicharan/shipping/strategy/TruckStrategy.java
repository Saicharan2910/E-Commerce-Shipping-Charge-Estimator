package com.saicharan.shipping.strategy;

import org.springframework.stereotype.Component;

@Component
public class TruckStrategy implements TransportStrategy{

	@Override
	public boolean supports(double distance) {
		return distance > 100 && distance <= 500;
	}

	@Override
	public double getRate() {
		return 2;
	}
}
