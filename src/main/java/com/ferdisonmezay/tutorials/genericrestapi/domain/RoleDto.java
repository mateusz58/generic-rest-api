package com.ferdisonmezay.tutorials.genericrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class RoleDto extends DTO implements Serializable {

    private String name;

    private String roleKey;

    private boolean isActive;

    @Builder
    public RoleDto(Long id, String name, String roleKey, boolean isActive) {
        super(id);
        this.name = name;
        this.roleKey = roleKey;
        this.isActive = isActive;
    }
}
