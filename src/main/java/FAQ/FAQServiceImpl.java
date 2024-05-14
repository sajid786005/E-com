package FAQ;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codewithproject.ecomDto.FAQDto;
import com.codewithproject.ecomEntity.FAQ;
import com.codewithproject.ecomEntity.Product;
import com.codewithproject.ecomRepository.FAQRepository;
import com.codewithproject.ecomRepository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FaqService {

	private FAQRepository faqRepository;
	
	private ProductRepository productRepository;
	
	
	public FAQDto postFaq(Long productId, FAQDto faqDto) {
		Optional<Product> optionalProductId = productRepository.findById(productId);
		if(optionalProductId.isPresent()) {
			FAQ faq = new FAQ();
			
			faq.setQuestion(faqDto.getQuestion());
			faq.setAnswer(faqDto.getAnswer());
			faq.setProduct(optionalProductId.get());
			
			return faqRepository.save(faq).getFAQDto();
			
			
		
		}
		
		return null;
	}


	@Override
	public FAQDto postFAQ(Long productId, FAQDto faqDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
