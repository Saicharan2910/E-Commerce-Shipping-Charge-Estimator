package com.saicharan.shipping.strategy;

import org.springframework.stereotype.Component;

@Component
public class MiniVanStrategy implements TransportStrategy {
	
	@Override
	public boolean supports(double distance) {
		return distance <= 100;
	}

	public double getRate() {
		return 3;
	}
}
