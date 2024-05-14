package com.codewithproject.ecomDto;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.codewithproject.ecomEntity.CartItems;
import com.codewithproject.ecomEntity.User;
import com.codewithproject.ecomEnums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class 
OrderDto {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderDescription;
	
	private Date date;
	
	private Long amount;
	
	private String address;
	
	private OrderStatus orderStatus;
	
	private Long totalAmount;
	
	private Long discount;
	
	private UUID trackingId;
	
	private String username;
	
	private List<CartItemsDto> cartItems;
	
	private String couponName;

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(String orderDescription, Date date, Long amount, String address, OrderStatus orderStatus,
			Long totalAmount, Long discount, UUID trackingId, String username, List<CartItemsDto> cartItems,
			String couponName) {
		super();
		this.orderDescription = orderDescription;
		this.date = date;
		this.amount = amount;
		this.address = address;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.trackingId = trackingId;
		this.username = username;
		this.cartItems = cartItems;
		this.couponName = couponName;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public void setId(Object id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}



