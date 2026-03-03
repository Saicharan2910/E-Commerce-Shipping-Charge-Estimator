package com.saicharan.shipping.enums;

public enum DeliveryType {
	
	STANDARD,
	EXPRESS;
	
	public static DeliveryType from(String value) {
		return DeliveryType.valueOf(value.toUpperCase());
	} 

}
