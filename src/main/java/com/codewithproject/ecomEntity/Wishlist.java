package com.codewithproject.ecomEntity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.codewithproject.ecomDto.WishlistDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "product_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;



	public static Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}



	public WishlistDto getwishlistDto() {
		WishlistDto wishlistDto = new WishlistDto();
		wishlistDto.setId(id);
		wishlistDto.setProducytId(product.getId());
		wishlistDto.setReturnedId(product.getImg());
		wishlistDto.setProductName(product.getName());
		wishlistDto.setProductDescription(product.getDescription());
		wishlistDto.setPrice(product.getPrice());
		wishlistDto.setUserId(user.getId());
		
		
		
		return wishlistDto;
	}



	public void setUser(User user2) {
		// TODO Auto-generated method stub
		
	}



	public void setProduct(Product product2) {
		// TODO Auto-generated method stub
		
	}

}
