package com.ferdisonmezay.tutorials.genericrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GrantDto extends DTO implements Serializable {

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
