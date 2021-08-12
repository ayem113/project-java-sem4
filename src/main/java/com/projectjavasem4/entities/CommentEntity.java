package com.projectjavasem4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
	
	
	@Column(name = "content",columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "stt")
	private Boolean stt;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user",nullable=false)
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product",nullable=false)
	private ProductEntity product;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getStt() {
		return stt;
	}

	public void setStt(Boolean stt) {
		this.stt = stt;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	
	
}
