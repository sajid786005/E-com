package FAQ;

import com.codewithproject.ecomDto.FAQDto;

public interface FaqService {
	
	
	FAQDto postFAQ( Long productId, FAQDto faqDto);

}
