package com.example.booking_service.controller;

import com.example.booking_service.models.Booking;
import com.example.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingsController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable int id) {
        Booking booking = bookingService.getBooking(id);
        
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/booking")
    public ResponseEntity<Object> addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

