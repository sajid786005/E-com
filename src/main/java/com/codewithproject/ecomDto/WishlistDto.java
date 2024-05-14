package com.codewithproject.ecomDto;

import lombok.Data;

@Data
public class WishlistDto {
	
	private Long userId;
	
	
	private Long producytId;
	
	private Long id;
	
	private String productName;
	
	private byte[] returnedId;
	
	private String productDescription;

	private Long price;


	public WishlistDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public WishlistDto(Long userId, Long producytId, Long id, String productName, byte[] returnedId,
			String productDescription, Long price) {
		super();
		this.userId = userId;
		this.producytId = producytId;
		this.id = id;
		this.productName = productName;
		this.returnedId = returnedId;
		this.productDescription = productDescription;
		this.price = price;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getProducytId() {
		return producytId;
	}


	public void setProducytId(Long producytId) {
		this.producytId = producytId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public byte[] getReturnedId() {
		return returnedId;
	}


	public void setReturnedId(byte[] returnedId) {
		this.returnedId = returnedId;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getProductId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
	
	

}
