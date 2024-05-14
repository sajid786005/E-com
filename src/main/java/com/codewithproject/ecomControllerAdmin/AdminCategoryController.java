package com.codewithproject.ecomControllerAdmin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.CategoryDto;
import com.codewithproject.ecomEntity.Category;
import com.codewithproject.ecomServicesAdminCategory.CategorySerivce;
import com.codewithproject.ecomServicesAdminCategory.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {
	
	
	private  CategorySerivce categorySerivce ;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCateGory(@RequestBody CategoryDto categoryDto){
		Category category = categorySerivce.createCategory(categoryDto);
		return  ResponseEntity.status(HttpStatus.CREATED).body(category);
		
		
	}
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		return ResponseEntity.ok(categorySerivce.getAllCategory());
		
	}

}
