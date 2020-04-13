package com.ferdisonmezay.tutorials.genericrestapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restapi_roles")
@Getter
@Setter
public final class RoleEntity extends ENTITY {

    @Column(name = "role_name")
    private String name;

    @Column(name = "role_key")
    private String roleKey;

    @Column(name = "is_active")
    private boolean isActive;

    public RoleEntity(Long id, String name, String roleKey, boolean isActive) {
        super(id);
        this.name = name;
        this.roleKey = roleKey;
        this.isActive = isActive;
    }
}
