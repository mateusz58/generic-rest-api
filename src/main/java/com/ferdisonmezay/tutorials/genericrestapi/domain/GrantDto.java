package com.ferdisonmezay.tutorials.genericrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class GrantDto extends DTO implements Serializable {

    private String name;

    private String grantKey;

    @Builder
    public GrantDto(Long id,String name, String grantKey) {
        super(id);
        this.name = name;
        this.grantKey = grantKey;
    }
}
