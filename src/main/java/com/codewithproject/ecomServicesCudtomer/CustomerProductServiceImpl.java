package com.codewithproject.ecomServicesCudtomer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.ProductDetailDto;
import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomEntity.FAQ;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomEntity.Review;
import com.codewithproject.ecomRepository.FAQRepository;
import com.codewithproject.ecomRepository.ProductRepository;
import com.codewithproject.ecomRepository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {
    
    private   ProductRepository productRepository;
    
    private FAQRepository faqRepository;
    
    private ReviewRepository reviewRepository;
    
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }


	public ProductDetailDto getProductDetailById(Long productId){
		Optional<Product>optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()){
			List<FAQ> faqList = faqRepository.findAllByProductId(productId);
			List<Review> reviewsList = reviewRepository.FindAllByProductId(productId);
			
			ProductDetailDto productDetailDto = new ProductDetailDto();
			
			productDetailDto.setProductDto(optionalProduct.get().getDto());
			ProductDetailDto.setFaqDtoList(faqList.stream().map(FAQ:: getFAQDto).collect(Collectors.toList()));
			ProductDetailDto.setReviewDtoList(reviewsList.stream().map(Review::getDto).collect(Collectors.toList()));
			
			return productDetailDto;
			
		}
		return null;
	}

	@Override
	public List<ProductDto> searchProductByTitle(String title) {
		
		return null;
	}

	
}
