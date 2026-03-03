package com.saicharan.shipping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
 
@Entity
@Data
public class Customer {

	@Id
	private Long id;
	
	private String name;
	
	private Double latitude;
	
	private Double longitude;
	
}
