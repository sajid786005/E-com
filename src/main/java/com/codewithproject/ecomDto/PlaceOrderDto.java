package com.codewithproject.ecomDto;

import lombok.Data;

@Data
public class PlaceOrderDto {

	
	
	private Long userId;
	
	
	private String address;
	
	private String orderDescription;

	public String getOrderDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
