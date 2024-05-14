package Coupon;

import java.util.List;

import com.codewithproject.ecomEntity.Coupon;

public interface AdminCouponService {

	
	Coupon createCoupon( Coupon coupon);
	
	List<Coupon>getAllCoupons();
}
