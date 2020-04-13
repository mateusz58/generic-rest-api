package com.ferdisonmezay.tutorials.genericrestapi.controller;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;

import com.ferdisonmezay.tutorials.genericrestapi.domain.ENTITY;
import com.ferdisonmezay.tutorials.genericrestapi.service.BasicServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferdisonmezay.tutorials.genericrestapi.domain.DTO;

public abstract class AbstractRestController<Dto extends DTO> {

    protected static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected static final String BASE_URL = "/api/v1";

    BasicServiceInterface<Dto> service;

    public AbstractRestController(BasicServiceInterface service) {
        this.service = service;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAll() {
	    return ResponseEntity.ok(service.getAll());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Dto entity) {
	    if(entity == null) {
	        String message = String.format("Request for %s  is null" , entity.getClass());
            log.error(message);
            throw new IllegalArgumentException(String.format(message , entity.getClass()));
        }
	    return new ResponseEntity(service.create(entity), HttpStatus.CREATED);
	}

	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> updateById(@PathVariable(value = "id") Long id, @RequestBody Dto entity) {
        if(id == null) {
            String message = String.format("Request id for %s  is null" , entity.getClass());
            log.error(message);
            throw new IllegalArgumentException(message);
        }
        if(entity == null) {
            String message = String.format("Request object for %s  is null" , entity.getClass());
            log.error(message);
            throw new IllegalArgumentException(message);
        }
        if(entity.getId() != id) {
            String message = String.format("Request to change object entity %s with not matching passed id to path" , entity.getClass());
            log.error(message);
            throw new IllegalArgumentException(message);
        }
        return new ResponseEntity(service.updateById(entity), HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id") Long id) {
        if(id == null) {
            String message = String.format("Request to delete entity %s with null id" , getGenericName());
            log.error(message);
            throw new IllegalArgumentException(message);
        }
		service.deleteById(id);
	}

    @GetMapping(value = "{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        if(id == null) {
            String message = String.format("Attempt to get %s entity with null id" , getGenericName());
            throw new IllegalArgumentException(message);
        }
        return new ResponseEntity(service.getById(id), HttpStatus.OK);
    }

    protected String getGenericName()
    {
        return ((Class<Dto>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }
}
