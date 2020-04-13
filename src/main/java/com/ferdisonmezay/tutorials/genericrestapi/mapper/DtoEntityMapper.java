package com.ferdisonmezay.tutorials.genericrestapi.mapper;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;
import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DtoEntityMapper<Entity extends ENTITY, Dto extends DTO> {
    Entity toEntity(Dto object);

    Dto toDto(Entity object);

    List<Dto> toDto(List<Entity> objects);

    List<Entity> toEntity(List<Dto> objects);
}
