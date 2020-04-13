package com.ferdisonmezay.tutorials.genericrestapi.dao;

import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseDao<T extends ENTITY> extends JpaRepository<T, Serializable> {
}
