package com.projectjavasem4.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissionDetail")
public class PermissionDetailEntity extends BaseEntity{

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permission",nullable=false)
	private PermissionEntity permission;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role",nullable=false)
	private RoleEntity role;

	public PermissionEntity getPermission() {
		return permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
	
	
}
