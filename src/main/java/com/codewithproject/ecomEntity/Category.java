package com.codewithproject.ecomEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	
	public Category() {
		super();
		
	}


	public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Lob
	private String description;


	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}


	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	

}
