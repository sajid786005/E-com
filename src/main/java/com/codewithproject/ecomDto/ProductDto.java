package com.codewithproject.ecomDto;

import org.springframework.web.multipart.MultipartFile;

import com.codewithproject.ecomEntity.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDto {
	
	private Long id;
	
	private String name;
	
	private Long price;
	
	
	private String description;
	
	
	private byte[]byteImg;
	
	private Long categoryId;
	
	private String categoryName;
	
	private MultipartFile img;
	
	private Long quamtity;
	
	

	public Long getQuamtity() {
		return quamtity;
	}



	public void setQuamtity(Long quamtity) {
		this.quamtity = quamtity;
	}



	public void setPrice(Long price) {
		this.price = price;
	}



	public ProductDto(Long id, String name, Long price, String description, byte[] byteImg, Long categoryId,
			String categoryName, MultipartFile img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.byteImg = byteImg;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.img = img;
	}
	
	

	public ProductDto() {
		super();
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getByteImg() {
		return byteImg;
	}

	public void setByteImg(byte[] byteImg) {
		this.byteImg = byteImg;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}



	public void setPrice(Product product) {
		// TODO Auto-generated method stub
		
	}



	public void setQuantity(Long quantity) {
		// TODO Auto-generated method stub
		
	}



}
