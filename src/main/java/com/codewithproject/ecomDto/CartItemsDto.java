package com.codewithproject.ecomDto;

import lombok.Data;

@Data
public class CartItemsDto {
	
	private Long Id;
	
	private Long price;
	
	private Long Quantity;
	
	private Long productId;
	
	private Long orderId;
	 
	private String productName;
	
	private byte[] returnedImg;
	
	
	
	
	public CartItemsDto() {
		super();
		
	}


	public CartItemsDto(Long id, Long price, Long quantity, Long productId, Long orderId, String productName,
			byte[] returnedImg, Long userId) {
		super();
		Id = id;
		this.price = price;
		Quantity = quantity;
		this.productId = productId;
		this.orderId = orderId;
		this.productName = productName;
		this.returnedImg = returnedImg;
		this.userId = userId;
	}


	private Long userId;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getQuantity() {
		return Quantity;
	}


	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productDto) {
		this.productName = productDto;
	}


	public byte[] getReturnedImg() {
		return returnedImg;
	}


	public void setReturnedImg(byte[] returnedImg) {
		this.returnedImg = returnedImg;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}



		
	}
	
	


