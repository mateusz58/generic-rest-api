package com.ferdisonmezay.tutorials.genericrestapi.domain;

import java.io.Serializable;

public abstract class DTO implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }
}
