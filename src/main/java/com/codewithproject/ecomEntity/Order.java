package com.codewithproject.ecomEntity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.codewithproject.ecomDto.OrderDto;
import com.codewithproject.ecomEnums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "orders")
public class Order {
	
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderDescription;
	
	private Date date;
	
	private Long amount;
	
	private String address;
	
	private OrderStatus orderStatus;
	
	private Long totalAmount;
	
	private Long discount;
	
	
	
	public Order(String orderDescription, Date date, Long amount, String address, OrderStatus orderStatus,
			Long totalAmount, Long discount, UUID trackingId, User user, User coupon, List<CartItems> cartItems) {
		super();
		this.orderDescription = orderDescription;
		this.date = date;
		this.amount = amount;
		this.address = address;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.trackingId = trackingId;
		this.user = user;
		this.coupon = coupon;
		this.cartItems = cartItems;
	}

	


	public Order() {
		super();
		
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public User getCoupon() {
		return coupon;
	}



	public void setCoupon(User coupon) {
		this.coupon = coupon;
	}



	public List<CartItems> getCartItems() {
		return cartItems;
	}



	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}



	private UUID trackingId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private User coupon;
	
	private List<CartItems> cartItems;
	
	
	
	public OrderDto getorderDto(Object id){
		OrderDto orderDto = new OrderDto();
		
		orderDto.setId(id);
		orderDto.setOrderDescription(orderDescription);
		orderDto.setAddress(address);
		orderDto.setTrackingId(trackingId);
		orderDto.setAmount(amount);
		orderDto.setDate(date);
		orderDto.setOrderStatus(orderStatus);
		orderDto.setUsername(user.getName());
		if(coupon !=null) {
			orderDto.setCouponName(coupon.getName());
		}
		
		return orderDto;
		
		
	}




	public org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto getOderDto() {
		
		return null;
	}




	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
