package com.codewithproject.ecomDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnalyticsResponse {
	
	private long placed;
	
	private Long shipped;
	
	private Long delivred;
	
	private Long currentMonthOrders;
	
	private Long previousMonthOrders;
	
	private long currentMonthEarnings;
	
	private Long previousMonthEarnings;

}
