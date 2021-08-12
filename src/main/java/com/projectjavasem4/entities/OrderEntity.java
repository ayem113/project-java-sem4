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

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

	@Column(name = "address", columnDefinition = "TEXT")
	private String address;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "stt")
	private Boolean stt;
	
	@Column(name = "sale")
	private Byte sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user",nullable=false)
	private UserEntity user;
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();



	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public Boolean getStt() {
		return stt;
	}


	public void setStt(Boolean stt) {
		this.stt = stt;
	}


	public Byte getSale() {
		return sale;
	}


	public void setSale(Byte sale) {
		this.sale = sale;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}


	
	
	
}
