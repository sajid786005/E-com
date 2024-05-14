package Coupon;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithproject.ecomEntity.Coupon;
import com.codewithproject.ecomException.ValidationException;
import com.codewithproject.ecomRepository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCoponServiceImpl implements AdminCouponService {

	private  CouponRepository couponRepository;
	
	
	public Coupon createCopon(Coupon  coupon) {
		if(couponRepository.existsByCode(coupon.getCode())) {
			throw new ValidationException("Coupon code already exists. ");
		}
		return couponRepository.save(coupon);
		
		
	}


	@Override
	public Coupon createCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}
}
