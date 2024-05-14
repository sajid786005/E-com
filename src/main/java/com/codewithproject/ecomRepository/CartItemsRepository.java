package com.codewithproject.ecomRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithproject.ecomEntity.CartItems;
import com.codewithproject.ecomEntity.Order;
import com.codewithproject.ecomEnums.OrderStatus;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
	
	 Optional<CartItems> findByProductIdAndOrderIdAndUserId(Long productId,Long orderId, Long UserId);

}
