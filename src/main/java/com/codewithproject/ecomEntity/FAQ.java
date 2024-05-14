package com.codewithproject.ecomEntity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.codewithproject.ecomDto.FAQDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class FAQ {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long Id;
	
	private String Question;
	
	private String Answer;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "product_Id", nullable =false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;




	public FAQDto getFAQDto() {
		FAQDto faqDto = new FAQDto();
		faqDto.setId(Id);
		faqDto.setQuestion(Question);
		faqDto.setAnswer(Question);
		faqDto.setProductId(Product.getId);
		
		return faqDto;
	}




	public void setQuestion(String question2) {
		// TODO Auto-generated method stub
		
	}




	public void setAnswer(String answer2) {
		// TODO Auto-generated method stub
		
	}




	public void setProduct(Product product2) {
		// TODO Auto-generated method stub
		
	}
	

}
