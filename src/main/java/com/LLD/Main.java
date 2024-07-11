package com.LLD;

import com.LLD.models.CustomerType;
import com.LLD.models.DayType;
import com.LLD.models.Hotel;
import com.LLD.repos.HotelRepositery;
import com.LLD.services.BookingService;

public class Main {
        public static void main(String[] args) {
            HotelRepositery hotelRepository = new HotelRepositery();
            BookingService bookingService = new BookingService(hotelRepository);

            Hotel cheapestHotel = bookingService.getCheapestHotel(CustomerType.REGULAR, DayType.WEEKDAY);
            System.out.println("Cheapest hotel: " + cheapestHotel.getName());
        }
    }