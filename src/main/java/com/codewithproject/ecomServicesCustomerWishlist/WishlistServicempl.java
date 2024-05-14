package com.codewithproject.ecomServicesCustomerWishlist;

import java.io.IOException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.WishlistDto;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomEntity.User;
import com.codewithproject.ecomEntity.Wishlist;
import com.codewithproject.ecomRepository.ProductRepository;
import com.codewithproject.ecomRepository.UserRepository;
import com.codewithproject.ecomRepository.WishLyistRepositor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServicempl implements WatchService {
	
	@Autowired
	private   UserRepository userReposeitory;

	@Autowired
	private  ProductRepository productRepository;

	@Autowired
	private   WishLyistRepositor  wishlistRepository;
	
	
	public WishlistDto addproductToWishlist(WishlistDto wishlistDto) {
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = productRepository.findById(Wishlist.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProduct(optionalProduct.get());
			wishlist.setUser(optionalUser.get());
			
			return wishlistRepository.save(wishlist).getwishlistDto();
			
		}
		return null;
	}
	
	public List<WishlistDto> getWishlistByUserId(Long userId){
		return wishlistRepository.findAllBYUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
	}


	public static WishlistServise addProducttoWishlist(WishlistDto wishlistDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public WatchKey poll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WatchKey take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
