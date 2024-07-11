package com.LLD.models;

import java.util.Map;

public class Hotel {
    private String name;
    private Map<CustomerType, Map<DayType, Integer>> rates;
    private  int rating;

    public Hotel(String name, Map<CustomerType, Map<DayType, Integer>> rates, int rating) {
        this.name = name;
        this.rates = rates;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Map<CustomerType, Map<DayType, Integer>> getRates() {
        return rates;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRates(Map<CustomerType, Map<DayType, Integer>> rates) {
        this.rates = rates;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
