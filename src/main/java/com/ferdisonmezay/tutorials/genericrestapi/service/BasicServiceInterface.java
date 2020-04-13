package com.ferdisonmezay.tutorials.genericrestapi.service;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasicServiceInterface<Dto extends DTO> {

    List<Dto> getAll();

    Dto updateById(Dto object);

    Dto getById(Long id);

    Dto create(Dto object);

    void deleteById(Long id);

    boolean existsById(Long id);

    void deleteAll();
}
