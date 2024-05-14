package com.codewithproject.ecomControllerCustomer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomDto.WishlistDto;
import com.codewithproject.ecomServicesCustomerWishlist.WishlistServicempl;
import com.codewithproject.ecomServicesCustomerWishlist.WishlistServise;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class WishlistController {
	
	private  WishlistServise wishlistServise;
	
	@PostMapping("/wishlist")
	public ResponseEntity<?> addProductToWishlist(@RequestBody WishlistDto  wishlistDto){
		WishlistServise postedWishlistDto  = WishlistServicempl.addProducttoWishlist(wishlistDto);
		if(postedWishlistDto== null);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
		
	}
	@GetMapping("/wishlist/{userId}")
	public ResponseEntity<List<WishlistDto>> getWishlistByuserId(@PathVariable long userId){
		return ResponseEntity.ok(wishlistServise.getwishlistByUserId(userId));
		
	}

}
