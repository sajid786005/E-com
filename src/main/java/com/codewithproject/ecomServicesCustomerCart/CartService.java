package com.codewithproject.ecomServicesCustomerCart;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.codewithproject.ecomDto.AddProductInCartDto;
import com.codewithproject.ecomDto.OrderDto;
import com.codewithproject.ecomDto.PlaceOrderDto;

public interface CartService {
	ResponseEntity<?>addProductToCart(AddProductInCartDto addProductinCartDto);
	
	
	org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto getCartByUserId(Long UserId);
	
	org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto applyCoupon(Long userId ,String code);
	
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto placeOrder(PlaceOrderDto placeOrderDto);
	
	
	List<OrderDto>  getMyPlacedOrder(Long userId);
	
	org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto searchOrderByTrackingId(UUID trackingId);
	

}
