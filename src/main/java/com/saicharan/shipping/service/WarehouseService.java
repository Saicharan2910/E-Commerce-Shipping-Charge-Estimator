package com.saicharan.shipping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saicharan.shipping.model.Warehouse;
import com.saicharan.shipping.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseService {
	
	private final WarehouseRepository repository;
	
	public Warehouse save(Warehouse warehouse) {
		return repository.save(warehouse);
	}

	public  List<Warehouse> getAll(){
		return repository.findAll();
	}
	
}
