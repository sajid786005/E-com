package com.codewithproject.ecomServices;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.codewithproject.ecomDto.AnalyticsResponse;

public interface AdminOrderService {
List<OrderDto> getAllPlacedOrder();
	
	OrderDto changOrderStatus(Long orderId, String Status);
	
	AnalyticsResponse calculateAnalytics();

}
