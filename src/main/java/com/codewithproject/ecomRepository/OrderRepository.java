package com.codewithproject.ecomRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithproject.ecomEntity.Order;
import com.codewithproject.ecomEnums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
	
	Order findByUserIdAndOrderStatus(Long userId);
	
	List<Order> findByStatusIn(List<OrderStatus> orderStatusList);

	
	List<Order> findByUserIdAndOrderStatusIn(Long UserId, List<OrderStatus> orderStatus);

	Optional<Order> findById(Long orderId);

	Optional<Order> findByTrackingId(UUID trackingId);
	
	List<Order> findByDateBeteweenAndOrderStatus(Date startOfMounth, Date endMonth, OrderStatus ststus); 
	
	Long CountByOrderStatus(OrderStatus status);

	Order findByUserIdAndOrderStatusIn(Long userId, OrderStatus pending);
}
