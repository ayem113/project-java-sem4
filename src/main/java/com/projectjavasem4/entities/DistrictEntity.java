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
@Table(name = "district")
public class DistrictEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "district")
	private List<WardEntity> wards = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_province",nullable=false)
	private ProvinceEntity province;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WardEntity> getWards() {
		return wards;
	}

	public void setWards(List<WardEntity> wards) {
		this.wards = wards;
	}

	public ProvinceEntity getProvince() {
		return province;
	}

	public void setProvince(ProvinceEntity province) {
		this.province = province;
	}
	
	
}
