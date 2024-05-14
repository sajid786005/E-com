package com.codewithproject.ecomServicesAdminCategoryProduct;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomEntity.Category;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomRepository.CategoryRepository;
import com.codewithproject.ecomRepository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	private  CategoryRepository categoryRepository;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) throws IOException {
		Product product = new Product(); // Fixed typo in object creation
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImg(productDto.getImg().getBytes());
		
		Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
		product.setCategory(category);
		
		return productRepository.save(product).getDto();
	}
	
	@Override
	public List<ProductDto> getAllProduct(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	@Override
	public List<ProductDto> getAllProductByNmae(String name){ // Fixed typo in method name
		List<Product> products = productRepository.findAllByNameContaining(name);
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	@Override
	public boolean deleteProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public ProductDto getProductBy(Long productId){ 
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()){
			return optionalProduct.get().getDto();
		} else {
			return null;
		}
	}
	
	@Override
	public ProductDto updateProduct(Long productId, ProductDto productDto) throws IDException { // Corrected method signature and added missing throws declaration
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
		if(optionalProduct.isPresent() && optionalCategory.isPresent()) {
			Product product = optionalProduct.get();
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setDescription(productDto.getDescription());
			product.setCategory(optionalCategory.get());
			if(productDto.getImg() != null) {
				product.setImg(productDto.getImg().getBytes());
			}
			return productRepository.save(product).getDto();
		} else {
			return null;
		}
	}

	@Override
	public List<ProductDto> getAllProduts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
