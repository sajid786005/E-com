package com.codewithproject.ecomRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithproject.ecomEntity.Wishlist;

@Repository
public interface WishLyistRepositor extends JpaRepository<Wishlist, Long> {
	
	
	List<Wishlist> findAllBYUserId(Long userId);
	
	

}
