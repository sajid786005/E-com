package com.codewithproject.ecomControllerCustomer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.ProductDetailDto;
import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomServicesCudtomer.CustomerProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerProductController {
	
	private  CustomerProductService customerProductService;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProduct() {
	     List<ProductDto> productDtos = customerProductService.getAllProducts();
	     return ResponseEntity.ok(productDtos);
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name) { 
	     List<ProductDto> productDtos = customerProductService.searchProductByTitle(name); 
	     return ResponseEntity.ok(productDtos);
	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDetailDto> getProductDetailById(@PathVariable Long productId){
		ProductDetailDto productDetailDto = customerProductService.getProductDetailById(productId);
		if(productDetailDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(productDetailDto);
	}
}
