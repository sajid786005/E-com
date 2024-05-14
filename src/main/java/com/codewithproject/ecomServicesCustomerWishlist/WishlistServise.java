package com.codewithproject.ecomServicesCustomerWishlist;

import java.util.List;

import com.codewithproject.ecomDto.WishlistDto;

public interface WishlistServise {

	WishlistDto addproductToWishlist(WishlistDto wishlistDto);
	
	List<WishlistDto>getwishlistByUserId(Long userId);
}
