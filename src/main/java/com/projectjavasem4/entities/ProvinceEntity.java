package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class ProvinceEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy = "province")
	private List<DistrictEntity> districts = new ArrayList<>();

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

	public List<DistrictEntity> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictEntity> districts) {
		this.districts = districts;
	}
	
	

}
