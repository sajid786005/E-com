package com.codewithproject.ecomServices;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.AnalyticsResponse;
import com.codewithproject.ecomEntity.Order;
import com.codewithproject.ecomEnums.OrderStatus;
import com.codewithproject.ecomRepository.OrderRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl {
	
	private   OrderRepository OrderRepository;
	
	public List<OrderDto> getAllPLaceOrders(){
		
		List<Order> orderList = OrderRepository.
				findByStatusIn(List.of(OrderStatus.Placed,OrderStatus.Delivered));
		
		return orderList.stream().toList().Map(Order::getOderDto).collect(Collectors.toList());
		
	}
	
	
	public OrderDto changeOrderStatus(Long orderId,String status) {
		Optional<Order> optionalOrder = OrderRepository.findById(orderId );
		if(optionalOrder.isPresent()){
			Order order = optionalOrder.get();
			
			if(Objects.equals(status, "Shipped")){
				order.setOrderStatus(OrderStatus.Shipped);
			}else if(Objects.equals(status, "Delivered")){
				order.setOrderStatus(OrderStatus.Delivered);
				
			}
			
			return OrderRepository.save(order).getOderDto();
		}
		return null;
		
	}
	public AnalyticsResponse calculateAnalytics(int monthsToSubtract){
	    LocalDate currentDate = LocalDate.now();
	    LocalDate previousMonthDate = currentDate.minusMonths(monthsToSubtract);
	   
	}
		Long currentMonthOrders = getTotalOrdersForMonth(currentDate.getMonthValue(), currentDate.getYear());
	    Long previousMonthOrders = getTotalOrderForMonth(previousMonthOrders.getMonthValue(), previousMonthEarnings.getYear());
	
	    Long currentMonthEarnings = getTotalEarningForMonth(currenDate.getMonthValue(), currentDate.getYear());
	    Long previousMonthEarnings = getTotalEarningForMonth(previousMonthValue(), previousMonthDate.getYear());
	    
	    Long placed =  OrderRepository(OrderStatus.Placed);
	    Long shipped =  OrderRepository(OrderStatus.Shipped);
	    Long delivered =  OrderRepository(OrderStatus.Delivered);
	    
	public Long getTotalOrdersForMonth(int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(month, 0);
		
		
		Date startOfMonth = calendar.getTime();
		
		calendar.set(calendar.DAY_OF_MONTH-month, calendar.getActualMaximum( Calendar.DAY_OF_MONTH));
		
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(calendar.MINUTE, 56);
		calendar.set(calendar.SECOND, 59);
		
		Date endOfMonth = calendar.getTime();
		
		List<Order> orders = OrderRepository.findByDateBetweenAndStatus(startOfMonth,endOfMonth, OrderStatus.Delivered);
		return (long) orders.size();
	}
	
	public Long getTotalEarrningForMonth(int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(month, 0);
		
		
		Date startOfMonth = calendar.getTime();
		
		calendar.set(calendar.DAY_OF_MONTH-month, calendar.getActualMaximum( Calendar.DAY_OF_MONTH));
		
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(calendar.MINUTE, 56);
		calendar.set(calendar.SECOND, 59);
		
		Date endOfMonth = calendar.getTime();
		
		List<Order> orders = OrderRepository.findByDateBetweenAndStatus(startOfMonth,endOfMonth, OrderStatus.Delivered);
	
		Long sum = 0L;
		for (Order order: orders) {
			sum +=order.getAmount();
		}
		return sum;
	}

}
