package com.codewithproject.ecomDto;

import lombok.Data;

@Data
public class FAQDto {
	
    private Long Id;
	
	private String Question;
	
	private String Answer;
	
	private Long productId;
	
	

	public FAQDto(Long id, String question, String answer, Long productSId) {
		super();
		Id = id;
		Question = question;
		Answer = answer;
		this.productId = productSId;
	}

	
	
	public FAQDto() {
		super();
		
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public Long getProductSId() {
		return productId;
	}

	public void setProductSId(Long getId) {
		this.productId = getId;
	}



	public void setProductId(Object getId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
