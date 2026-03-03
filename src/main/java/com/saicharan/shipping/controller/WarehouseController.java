package com.saicharan.shipping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.shipping.model.Warehouse;
import com.saicharan.shipping.service.WarehouseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
	
	private final WarehouseService service;
	
	@PostMapping
	public Warehouse create(@RequestBody Warehouse warehouse) {
		return service.save(warehouse);
	}

	@GetMapping
	public List<Warehouse> getAll(){
		return service.getAll();
	}
	
}
