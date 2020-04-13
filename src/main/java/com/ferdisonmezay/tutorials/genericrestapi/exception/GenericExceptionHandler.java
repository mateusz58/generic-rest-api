package com.ferdisonmezay.tutorials.genericrestapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.invoke.MethodHandles;
import java.time.Clock;
import java.time.Instant;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class GenericExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final Clock clock = Clock.systemDefaultZone();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return handleException(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> handleException(String message, HttpStatus httpStatus) {
        log.error("Error: " + message);
        ErrorResponse errorResponse = new ErrorResponse(Instant.now(clock), message);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
