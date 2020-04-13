package com.ferdisonmezay.tutorials.genericrestapi.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restapi_grants")
@Getter
@Setter
public final class GrantEntity extends ENTITY {

    @Column(name = "grant_name")
    private String name;

    @Column(name = "grant_key")
    private String grantKey;

    @Builder
    public GrantEntity(Long id, String name, String grantKey) {
        super(id);
        this.name = name;
        this.grantKey = grantKey;
    }
}
