package com.projectjavasem4.dto;

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

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSale() {
		return sale;
	}

	public void setSale(Byte sale) {
		this.sale = sale;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getList_img() {
		return list_img;
	}

	public void setList_img(String list_img) {
		this.list_img = list_img;
	}

	public Boolean getStt() {
		return stt;
	}

	public void setStt(Boolean stt) {
		this.stt = stt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public Long getId_orderDetails() {
		return id_orderDetails;
	}

	public void setId_orderDetails(Long id_orderDetails) {
		this.id_orderDetails = id_orderDetails;
	}

	public Long getId_comments() {
		return id_comments;
	}

	public void setId_comments(Long id_comments) {
		this.id_comments = id_comments;
	}
	
	
}
