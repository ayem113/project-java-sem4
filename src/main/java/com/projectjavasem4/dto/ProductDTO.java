package com.projectjavasem4.dto;

import lombok.Data;

@Data
public class ProductDTO extends AbstractDTO<ProductDTO> {
	
	

	private String name;
	
	private Byte sale;

	private Float price;

	private Integer quantity;

	private String img;

	private String list_img;

	private Boolean stt;

	private String description;

	
	private Long id_category;
	
	
	private  Long id_orderDetails ;
	
	private Long id_comments;

	
	
	
	
}
