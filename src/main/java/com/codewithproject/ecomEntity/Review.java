package com.codewithproject.ecomEntity;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import com.codewithproject.ecomDto.ReviewDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	
	private long rating;
	
	@Lob
	private String description;
	
	
	@Lob
	@Column(columnDefinition = "longblod")
	private byte[] ing;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private  Product product;

public Review getDto() {
	ReviewDto revieDto = new ReviewDto();
	
	revieDto.setId(id);
	revieDto.setRating(rating);
	revieDto.setDescription(description);
	revieDto.setReturnedImg(img);
	revieDto.setProductId(product.getId());
	revieDto.setUserId(user.getid())
	revieDto.setUsername(user.getName());
	
	return revieDto;
	
}

public void setUser(User user2) {
	// TODO Auto-generated method stub
	
}

public void setProduct(Product product2) {
	// TODO Auto-generated method stub
	
}

public Object getRating() {
	// TODO Auto-generated method stub
	return null;
}

public Object getDescription() {
	// TODO Auto-generated method stub
	return null;
}

public void setRating(Object rating2) {
	// TODO Auto-generated method stub
	
}

public void setDescription(Object description2) {
	// TODO Auto-generated method stub
	
}

public String getImg() {
	// TODO Auto-generated method stub
	return null;
}

public Long getUserId() {
	// TODO Auto-generated method stub
	return null;
}

public Long getProductId() {
	// TODO Auto-generated method stub
	return null;
}

public void setImg(byte[] bytes) {
	// TODO Auto-generated method stub
	
}
	
	}


