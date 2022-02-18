package com.example.booking_service.service;

import com.example.booking_service.BookingNotFoundException;
import com.example.booking_service.models.Booking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    
    public synchronized void addBooking(Booking booking) {
        if (booking.getId() != null) {
            bookings.add(booking);
        } else {
            booking.setId(bookings.size() + 1);
            bookings.add(booking);
        }
    }
    
    public synchronized Booking getBooking(int id) {
        Optional<Booking> foundBooking = bookings.stream().filter(booking -> booking.getId() == id).findFirst();
        if (foundBooking.isEmpty()) {
            throw new BookingNotFoundException(String.format("Booking not found for ID: %s", id));
        }
        
        return foundBooking.get();
    }
}
