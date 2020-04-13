package com.ferdisonmezay.tutorials.genericrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="restapi_roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoleEntity extends ENTITY {

	@Column(name="role_name")
	private String name;

	@Column(name="role_key")
	private String roleKey;

	@Column(name="is_active")
	private boolean isActive;

	public String getName() {
	    return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
