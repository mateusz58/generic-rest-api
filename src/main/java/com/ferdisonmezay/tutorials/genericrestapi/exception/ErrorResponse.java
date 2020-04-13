package com.ferdisonmezay.tutorials.genericrestapi.exception;

import java.time.Instant;

public class ErrorResponse {

    private final Instant instant;
    private final String message;

    public ErrorResponse(Instant instant, String message) {
        this.instant = instant;
        this.message = message;
    }

    public Instant getInstant() {
        return instant;
    }

    public String getMessage() {
        return message;
    }
}
