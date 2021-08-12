package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class PermissionEntity extends BaseEntity{
	
	
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "permission")
	private List<PermissionDetailEntity> permissionDetails = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<PermissionDetailEntity> getPermissionDetails() {
		return permissionDetails;
	}

	public void setPermissionDetails(List<PermissionDetailEntity> permissionDetails) {
		this.permissionDetails = permissionDetails;
	}
	
	
	

}
