package ServicesCustomerReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.IIOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.OrderedProductResponseDto;
import com.codewithproject.ecomDto.ProductDto;
import com.codewithproject.ecomDto.ReviewDto;
import com.codewithproject.ecomEntity.CartItems;
import com.codewithproject.ecomEntity.Order;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomEntity.Review;
import com.codewithproject.ecomEntity.User;
import com.codewithproject.ecomRepository.OrderRepository;
import com.codewithproject.ecomRepository.ProductRepository;
import com.codewithproject.ecomRepository.ReviewRepository;
import com.codewithproject.ecomRepository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private  OrderRepository orderRepository;
	
	@Autowired
	private  ProductRepository productRepository;
	
	@Autowired
	private  UserRepository  userRepository;
	
	@Autowired
	private  ReviewRepository reviewRepository;
	
	
	
	public OrderedProductResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		OrderedProductResponseDto orderedProductsResponseDto = new OrderedProductResponseDto();
		if(optionalOrder.isPresent()) {
			orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());
			
			List<ProductDto> productDtoList = new ArrayList<>();
			for (CartItems cartItems: optionalOrder.get().getCartItems()) {
				ProductDto productDto = new ProductDto();
				
				productDto.setId(cartItems.getProduct().getId());
				productDto.setName(cartItems.getProduct().getName());
				productDto.setPrice(cartItems.getProduct());
				productDto.setQuantity(cartItems.getQuantity());
				
				productDto.setByteImg(cartItems.getProduct().getImg());
				
				productDtoList.add(productDto);
			}
			orderedProductsResponseDto.setProductDtoList(productDtoList);
		}
		return orderedProductsResponseDto;
	}
	
	public Review giveReview(Review reviewDto) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
		Optional<org.springframework.boot.autoconfigure.security.SecurityProperties.User> optionalUser = userRepository.findById(reviewDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Review review = new Review();
			
			review.setRating(reviewDto.getRating());
			review.setDescription(reviewDto.getDescription());
			review.setUser(optionalUser.get());
			review.setProduct(optionalProduct.get());
			review.setImg(reviewDto.getImg().getBytes());
			
			return  reviewRepository.save(review).getDto();
		}
		return null;
	}

	@Override
	public ReviewDto giveReview(ReviewDto reviwDto) throws IIOException {
		// TODO Auto-generated method stub
		return null;
	}
}