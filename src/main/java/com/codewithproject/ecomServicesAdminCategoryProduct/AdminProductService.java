package com.codewithproject.ecomServicesAdminCategoryProduct;

import java.io.IOException;
import java.util.List;

import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomEntity.Product;

public interface AdminProductService {
	
	
	ProductDto addProduct(ProductDto productDto) throws IOException;
	
	List<ProductDto>getAllProduts();
	
	 List<Product> getAllProductByNmae(String name);
	 
	 boolean deleteProduct(Long id);
	 
	 ProductDto getProduct( long id);
	 
	 Product getProductById(Long productId);
	 
	 ProductDto updateProduct(Long productId, ProductDto  productDto) ;

}
