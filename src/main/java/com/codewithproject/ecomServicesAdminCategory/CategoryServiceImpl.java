package com.codewithproject.ecomServicesAdminCategory;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.CategoryDto;
import com.codewithproject.ecomEntity.Category;
import com.codewithproject.ecomRepository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategorySerivce {
	private final CategoryRepository categoryRepository = null;

	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
		
	}
}
