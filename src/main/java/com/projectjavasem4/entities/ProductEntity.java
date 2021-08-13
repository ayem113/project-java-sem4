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

import lombok.Data;

@Entity
@Table(name = "product")
@Data
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

	
}
