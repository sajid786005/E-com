package com.codewithproject.ecomController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomEntity.Coupon;
import com.codewithproject.ecomException.ValidationException;

import Coupon.AdminCouponService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/coupon")
@RequiredArgsConstructor
public class AdminCouponController {
	
	private  AdminCouponService adminCouponService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createCoupon(@Validated @RequestBody Coupon coupon) {
		try {
			Coupon createdCoupon = adminCouponService.createCoupon(coupon);
			return ResponseEntity.ok(createdCoupon);
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		List<Coupon> coupons = adminCouponService.getAllCoupons();
		return ResponseEntity.ok(coupons);
	}
}
