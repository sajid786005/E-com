package com.codewithproject.ecomRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithproject.ecomEntity.FAQ;
import com.codewithproject.ecomEntity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findAllByProductId(Long productId);

	List<Review> FindAllByProductId(Long productId);

}
