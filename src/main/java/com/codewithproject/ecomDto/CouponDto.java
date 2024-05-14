package com.codewithproject.ecomDto;

import java.sql.Date;

import lombok.Data;

@Data
public class CouponDto {
	
	private long id ;
	
	private String name;
	
	private String code;
	
	private long discount;
	
	private  Date expirationDate;
	

}
