package com.LLD.services;


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

    public Hotel getCheapestHotel(CustomerType custsomerType, DayType dayTime){
        List<Hotel> hotellist=hotelRepositery.getHotels();
        List<Hotel> cheapesthotel= new ArrayList<>();
        double myprice=Double.MAX_VALUE;
        for(Hotel hotel:hotellist){
            Integer rateforcustomerdaytime = hotel.getRates().get(custsomerType).get(dayTime);
            if(rateforcustomerdaytime<myprice){
                myprice=rateforcustomerdaytime;
                cheapesthotel.clear();
                cheapesthotel.add(hotel);
            }
            else{
                if(rateforcustomerdaytime==myprice){
                    cheapesthotel.add(hotel);
                }
            }
        }
        if(cheapesthotel.size()==1)return cheapesthotel.get(0);
        else{
            Hotel besthotel=cheapesthotel.get(0);
            for(Hotel hotel:cheapesthotel){
                if(hotel.getRating()>besthotel.getRating()){
                    besthotel=hotel;
                }
            }
            return besthotel;
        }
    }
}
