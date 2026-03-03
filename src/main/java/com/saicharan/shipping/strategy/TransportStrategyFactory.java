package com.saicharan.shipping.strategy;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportStrategyFactory {
	
	private final List<TransportStrategy> strategies;
	
	public TransportStrategy getStrategy(double distance) {
		
		return strategies.stream()
				.filter(strategy -> strategy.supports(distance))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No transport strategy found"));
	}

}
