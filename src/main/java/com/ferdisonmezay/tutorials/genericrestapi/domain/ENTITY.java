package com.ferdisonmezay.tutorials.genericrestapi.domain;

import javax.persistence.*;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class ENTITY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private Long id;

    public Long getId() {
        return id;
    }
}
