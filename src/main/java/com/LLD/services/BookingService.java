package com.LLD.services;


import com.LLD.Exceptions.DayTimeInvalid;
import com.LLD.Exceptions.customerNotFound;
import com.LLD.models.CustomerType;
import com.LLD.models.DayType;
import com.LLD.models.Hotel;
import com.LLD.repos.HotelRepositery;

import java.util.ArrayList;
import java.util.List;



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
        List<Hotel> cheapestHotel= new ArrayList<>();
        final Integer[] myPrice = {Integer.MAX_VALUE};
        hotellist.forEach(hotel -> {
            Integer rateCustomerDaytime = hotel.getRate(customerType, dayTime);
            if(rateCustomerDaytime < myPrice[0]){
                myPrice[0] = rateCustomerDaytime;
                cheapestHotel.clear();
                cheapestHotel.add(hotel);
            }
            else{
                if(rateCustomerDaytime == myPrice[0]){
                    cheapestHotel.add(hotel);
                }
            }
        });
        return cheapestHotel.size() == 1 ? cheapestHotel.get(0) : cheapestHotel.stream().min((h1, h2) -> h1.getRating() - h2.getRating()).get();

    }
}
