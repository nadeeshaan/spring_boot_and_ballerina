package com.example.booking_service;

public class DuplicateBookingIDException extends RuntimeException {
    public DuplicateBookingIDException(String message) {
        super(message);
    }
}
