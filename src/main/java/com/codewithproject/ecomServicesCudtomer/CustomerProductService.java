package com.codewithproject.ecomServicesCudtomer;

import java.util.List;

import com.codewithproject.ecomDto.ProductDetailDto;
import com.codewithproject.ecomDto.ProductDto;

public interface CustomerProductService {
	
	
	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();
	
	ProductDetailDto getProductDetailById(Long productId);

}
