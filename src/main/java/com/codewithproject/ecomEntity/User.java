package com.codewithproject.ecomEntity;

import com.codewithproject.ecomEnums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	
	private String password;
	
	
	private String name;
	
	private UserRole role;

	public void setEmail(String string) {
		
		
	}

	public void setFullName(String string) {
		
		
	}

	public long getId() {
		
		return 0;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}

	public void setRole(UserRole admin) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		
		return null;
	}
	
	
	
	
	
	
}
