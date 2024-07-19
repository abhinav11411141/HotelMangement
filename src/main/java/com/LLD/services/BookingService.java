package com.LLD.services;


import com.LLD.Exceptions.DayTimeInvalid;
import com.LLD.Exceptions.customerNotFound;
import com.LLD.models.CustomerType;
import com.LLD.models.DayType;
import com.LLD.models.Hotel;
import com.LLD.repos.HotelRepositery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class BookingService {
    HotelRepositery hotelRepositery;

    public BookingService(HotelRepositery hotelRepositery) {
        this.hotelRepositery = hotelRepositery;
    }

    public Hotel getCheapestHotel(CustomerType customerType, DayType dayTime) throws DayTimeInvalid , customerNotFound {

         if(customerType == null){
            throw new customerNotFound("Customer Type is not found");}
         if(dayTime == null){
            throw new DayTimeInvalid("Day Time is not found");}



        List<Hotel> hotellist=hotelRepositery.getHotels();
          Optional<Hotel> cheapestHotel;
        cheapestHotel = hotellist.stream().min((h1, h2) -> {
            if (Objects.equals(h1.getRate(customerType, dayTime), h2.getRate(customerType, dayTime))) {
                return h1.getRating() - h2.getRating();
            }
            return h1.getRate(customerType, dayTime) - h2.getRate(customerType, dayTime);
        });
        return cheapestHotel.orElseThrow();


    }
}
