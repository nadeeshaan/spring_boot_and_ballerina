package com.example.booking_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Booking {
    private Integer id;
    private String hotelName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bookingDate;

    public Booking(Integer id, String hotelName, Date bookingDate) {
        this.id = id;
        this.hotelName = hotelName;
        this.bookingDate = bookingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
