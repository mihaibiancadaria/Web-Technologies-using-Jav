package com.project.AirlineEticketing.exception;

public class Duplicate extends RuntimeException {
    public Duplicate() {
        super("There is already a record with the same code.");
    }
}
