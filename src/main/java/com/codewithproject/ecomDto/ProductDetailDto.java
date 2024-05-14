package com.codewithproject.ecomDto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDetailDto {
	
	
	private ProductDto productDto;
	
	private List<ReviewDto> reviewDtoList;
	
	private List<FAQDto>faqDtoList;

	public void setProductDto(ProductDto dto) {
		
		
	}

	public static void setFaqDtoList(List<FAQDto> collect) {
		
		
	}

	public static void setReviewDtoList(List<ReviewDto> collect) {
		
		
	}

}
