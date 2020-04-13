package com.ferdisonmezay.tutorials.genericrestapi.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;

public interface BaseDao<T extends DTO> extends JpaRepository<Long, Serializable> {
}
