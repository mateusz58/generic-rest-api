package com.ferdisonmezay.tutorials.genericrestapi.service;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;
import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;
import com.ferdisonmezay.tutorials.genericrestapi.mapper.DtoEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.invoke.MethodHandles;
import java.util.List;


public  class GenericServiceImpl<Dto extends DTO, Entity extends ENTITY> implements BasicServiceInterface <Dto> {

    protected static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected JpaRepository<Entity, Long> repository;

    protected DtoEntityMapper<Entity, Dto> mapper;

    public GenericServiceImpl(JpaRepository<Entity, Long> repository, DtoEntityMapper<Entity, Dto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Dto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public Dto updateById(Dto object) {
        return mapper.toDto(repository.save(mapper.toEntity(object)));
    }

    @Override
    public Dto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public Dto create(Dto object) {
        return mapper.toDto(repository.save(mapper.toEntity(object)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        if(repository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
