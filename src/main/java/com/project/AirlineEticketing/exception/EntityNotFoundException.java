package com.project.AirlineEticketing.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity) {
        super(String.format("Entity: %s was not found", entity));
    }
}
