package com.codewithproject.ecomControllerCustomer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.OrderedProductResponseDto;
import com.codewithproject.ecomDto.ReviewDto;

import ServicesCustomerReview.ReviewService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coustomer")
public class ReviewController {
	
	private ReviewService reviewService;
	
	@GetMapping("/ordered-product/{orderId}")
	public ResponseEntity<String> getOrderedProductDetailsByorderId(@PathVariable Long orderId){
		return ResponseEntity.ok(ReviewService.getOrderProductsDetailByOrderId(orderId));
		
		
		public  ResponseEntity<?> giveReviw( @ModelAttribute ReviewDto reviwDto){
			ReviewDto reviewDto1 = reviewService.GiveReview(reviwDto);
			if(reviewDto1 ==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something ewnt worong");
			return ResponseEntity.status(HttpStatus.CREATED).body(reviwDto);
		}
		
	}

}
