package com.ferdisonmezay.tutorials.genericrestapi.service;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;
import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;

import java.util.List;

public interface BasicServiceInterface<Dto extends DTO> {

    List<Dto> getAll();

    Dto updateById(Dto object);

    Dto getById(Long id);

    Dto create(Dto object);

    void deleteById(Long id);

    boolean existsById(Long id);

    void  deleteAll();
}
