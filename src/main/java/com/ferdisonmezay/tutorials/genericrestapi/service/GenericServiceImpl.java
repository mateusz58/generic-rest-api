package com.ferdisonmezay.tutorials.genericrestapi.service;

import com.ferdisonmezay.tutorials.genericrestapi.dao.BaseDao;
import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;
import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;
import com.ferdisonmezay.tutorials.genericrestapi.mapper.DtoEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public abstract class GenericServiceImpl<Dto extends DTO, Entity extends ENTITY> implements BasicServiceInterface<Dto> {

    protected static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected BaseDao<Entity> repository;

    protected DtoEntityMapper<Entity, Dto> mapper;

    public GenericServiceImpl(BaseDao<Entity> repository, DtoEntityMapper<Entity, Dto> mapper) {
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
        if (repository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
