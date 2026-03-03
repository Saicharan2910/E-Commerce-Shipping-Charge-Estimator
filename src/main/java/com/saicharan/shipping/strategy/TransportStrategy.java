package com.saicharan.shipping.strategy;

public interface TransportStrategy {

	boolean supports(double distance);
	
	double getRate();
}
