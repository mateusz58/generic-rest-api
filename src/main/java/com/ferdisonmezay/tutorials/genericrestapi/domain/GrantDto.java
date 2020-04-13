package com.ferdisonmezay.tutorials.genericrestapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GrantDto extends DTO {

	private String name;

	private String grantKey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrantKey() {
		return grantKey;
	}

	public void setGrantKey(String grantKey) {
		this.grantKey = grantKey;
	}
}
