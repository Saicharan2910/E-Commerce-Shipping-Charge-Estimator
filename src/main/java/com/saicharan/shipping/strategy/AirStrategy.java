package com.saicharan.shipping.strategy;

import org.springframework.stereotype.Component;

@Component
public class AirStrategy implements TransportStrategy{

	@Override
	public boolean supports(double distance) {
		return distance > 500;
	}

	@Override
	public double getRate() {
		return 1;
	}

}
