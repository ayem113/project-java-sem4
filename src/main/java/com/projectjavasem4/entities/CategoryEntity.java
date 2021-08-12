package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

	@Column(name = "id_parent")
	private Long id_parent;

	@Column(name = "name")
	private String name;

	@Column(name = "img", columnDefinition = "TEXT")
	private String img;

	@Column(name = "list_img", columnDefinition = "TEXT")
	private String list_img;

	@Column(name = "stt")
	private Boolean stt;

	@OneToMany(mappedBy = "category")  //@JsonIgnore
	private List<ProductEntity> products = new ArrayList<>();

	public Long getId_parent() {
		return id_parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public void setId_parent(Long id_parent) {
		this.id_parent = id_parent;
	}

}
