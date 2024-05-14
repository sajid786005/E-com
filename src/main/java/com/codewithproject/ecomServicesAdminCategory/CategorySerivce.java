package com.codewithproject.ecomServicesAdminCategory;

import java.util.List;

import com.codewithproject.ecomDto.CategoryDto;
import com.codewithproject.ecomEntity.Category;

public interface CategorySerivce {
	
	Category createCategory(CategoryDto categoryDto);
	
	List<Category> getAllCategory();

}
