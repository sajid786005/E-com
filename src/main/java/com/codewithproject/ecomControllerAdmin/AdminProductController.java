package com.codewithproject.ecomControllerAdmin;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.FAQDto;
import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomRepository.ProductRepository;
import com.codewithproject.ecomServicesAdminCategoryProduct.AdminProductService;

import FAQ.FaqService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {
	
	private  AdminProductService adminProductService;
	
	private FaqService  faqService;
	
	@PostMapping()
	public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException{
		
		ProductDto productDto1 = adminProductService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
	}
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productDtos = adminProductService.getAllProduts();
		return ResponseEntity.ok(productDtos);
	}
	@GetMapping("/search/{name}")
	public ResponseEntity<List<Product>> getAllProducts(@PathVariable String name){
		List<Product> productDtos = adminProductService.getAllProductByNmae(name);
		return ResponseEntity.ok(productDtos);
	
	}
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Void> deleteProuduct(@PathVariable Long productId){
		boolean deleted = adminProductService.deleteProduct(productId);
		if(deleted){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	@PostMapping("/faq/{productId}")
	public ResponseEntity<FAQDto> postFaq(@PathVariable Long productId, @RequestBody FAQDto faqDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(faqService.postFAQ(productId, faqDto));
	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId ){
	    ProductDto productDto = adminProductService.getProduct(productId);
         if( productDto != null){
        	 return ResponseEntity.ok(productDto);
         }else {
        	 return ResponseEntity.notFound().build();
         }
}
  }
