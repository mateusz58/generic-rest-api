package com.ferdisonmezay.tutorials.genericrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public abstract class DTO implements Serializable {

    private Long id;
}
