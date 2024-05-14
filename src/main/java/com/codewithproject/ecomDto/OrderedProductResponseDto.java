package com.codewithproject.ecomDto;

import java.util.List;

import lombok.Data;

@Data
public class OrderedProductResponseDto {

	
	private List<ProductDto> productList;
	
	private Long OrderAmount;

	public void setOrderAmount(Long amount) {
		// TODO Auto-generated method stub
		
	}

	public void setProductDtoList(List<ProductDto> productDtoList) {
		// TODO Auto-generated method stub
		
	}
}
