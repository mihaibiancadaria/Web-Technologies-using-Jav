package com.project.AirlineEticketing.exception;

public class EntityNotFoundIntegerException extends RuntimeException {

    public EntityNotFoundIntegerException(Integer entity) {
        super(String.format("Entity: %s was not found", entity));
    }
}
