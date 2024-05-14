package com.codewithproject.ecomDto;

import com.codewithproject.ecomEnums.UserRole;

import lombok.Data;

@Data
public class UserDto {

	
	private Long id;
	
	private String email; 
	
	private String name;
	
	private UserRole userRole;

	public void setId(long id2) {
		
		
	}
	
}
