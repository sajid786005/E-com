package com.codewithproject.ecomController;

import java.util.UUID;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomServicesCustomerCart.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
public class TrackingController {

	
	
	private  CartService cartService;
	
	@GetMapping("/order/{trackingId}")
	public ResponseEntity<OrderDto> serchOrderTrackingId(@PathVariable UUID trackingId){
		OrderDto orderDto = cartService.searchOrderByTrackingId(trackingId);
		if(orderDto ==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(orderDto);
	}
}
