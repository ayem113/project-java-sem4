package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	

	//@JsonIgnore
	@Column(name = "name")
	private String name;

	@Column(name = "sale")
	private Byte sale;

	@Column(name = "price")
	private Float price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "img", columnDefinition = "TEXT")
	private String img;

	@Column(name = "list_img", columnDefinition = "TEXT")
	private String list_img;

	@Column(name = "stt")
	private Boolean stt;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category",nullable=false)
	@JsonIgnore
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<CommentEntity> comments = new ArrayList<>();

	public String getName() {
		return name;
	}

	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
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

	public String getShortDescription() {
		return description;
	}

	public void setShortDescription(String shortDescription) {
		this.description = shortDescription;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
