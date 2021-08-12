package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "role")
	private List<UserEntity> users = new ArrayList<>();

	@OneToMany(mappedBy = "role")
	private List<PermissionDetailEntity> permissionDetails = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<PermissionDetailEntity> getPermissionDetails() {
		return permissionDetails;
	}

	public void setPermissionDetails(List<PermissionDetailEntity> permissionDetails) {
		this.permissionDetails = permissionDetails;
	}

}
