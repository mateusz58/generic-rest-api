package com.ferdisonmezay.tutorials.genericrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoleDto extends DTO {

	private String name;

	private String roleKey;

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
