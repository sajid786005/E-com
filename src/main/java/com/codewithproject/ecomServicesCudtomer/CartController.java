package com.codewithproject.ecomServicesCudtomer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.AddProductInCartDto;
import com.codewithproject.ecomDto.OrderDto;
import com.codewithproject.ecomDto.PlaceOrderDto;
import com.codewithproject.ecomException.ValidationException;
import com.codewithproject.ecomServicesCustomerCart.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CartController {

	private  CartService cartService;
	
	@PostMapping("/cart")
	public ResponseEntity<?> addToCart(@RequestBody AddProductInCartDto addProductInCartDto){
		return cartService.addProductToCart(addProductInCartDto);
		}
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<?> getCartByUserId(@PathVariable Long userId){
		org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto orderDto = cartService.getCartByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(orderDto) ;
	}
	
	@GetMapping("/coupon/{userId}/{code}")
	public ResponseEntity<?> applyCoupon(@PathVariable Long userId, @PathVariable String code){
		try {
			org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto orderDto = cartService.applyCoupon(userId, code);
			return ResponseEntity.ok(orderDto);
		}catch(ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@PostMapping("/addition")
	public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseProductQuantity(addProductInCartDto));
		}

	@PostMapping("/deduction")
	public ResponseEntity<OrderDto> decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.decreaseProductQuantity(addProductInCartDto));
		}

	@PostMapping("/placeOrder")
	public ResponseEntity<org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.placeOrder(placeOrderDto));
		}
	@GetMapping("/myOrder/{userId}")
	public ResponseEntity<List<OrderDto>>getMyPlacedOrder(@PathVariable Long UserId){
		return ResponseEntity.ok(cartService.getMyPlacedOrder(UserId));
	}
	
}