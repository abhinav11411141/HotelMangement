package com.LLD.controllers;


import com.LLD.models.CustomerType;
import com.LLD.models.DayType;
import com.LLD.models.Hotel;
import com.LLD.services.BookingService;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Hotel getCheapestPrice(CustomerType custsomerType, DayType dayTime) {
         return bookingService.getCheapestHotel( custsomerType, dayTime);

    }

}
