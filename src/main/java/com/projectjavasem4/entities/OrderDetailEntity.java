package com.projectjavasem4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "orderDetail")
public class OrderDetailEntity extends BaseEntity{

	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "sale")
	private Byte sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order",nullable=false)
	private OrderEntity order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product",nullable=false)
	private ProductEntity product;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Byte getSale() {
		return sale;
	}

	public void setSale(Byte sale) {
		this.sale = sale;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	
}
