package ServicesCustomerReview;

import javax.imageio.IIOException;

import com.codewithproject.ecomDto.OrderedProductResponseDto;
import com.codewithproject.ecomDto.ReviewDto;

public interface ReviewService {
	
	OrderedProductResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

	ReviewDto giveReview(ReviewDto reviwDto) throws IIOException;

	static String getOrderProductsDetailByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	
	

