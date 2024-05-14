package com.codewithproject.ecomDto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import com.codewithproject.ecomEntity.User;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
public class ReviewDto {
	
	
	private Long id;

	
	private Long rating;
	
	
	private String description;
	
	private MultipartFile img;
	
	private byte[] returnedImg;
	
	private User userId;
	

	private User productId;
	
	private String username;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setRating(long rating2) {
		// TODO Auto-generated method stub
		
	}

	public void setDescription(String description2) {
		// TODO Auto-generated method stub
		
	}

	public void setProductId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setUsername(String name) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	

}
