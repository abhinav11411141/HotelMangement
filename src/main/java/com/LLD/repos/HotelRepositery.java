package com.LLD.repos;

import com.LLD.models.CustomerType;
import com.LLD.models.DayType;
import com.LLD.models.Hotel;

import java.util.List;
import java.util.Map;

public class HotelRepositery {
    Hotel miamiBeach = new Hotel(
            "Miami Beach",
            Map.of(
                    CustomerType.REGULAR, Map.of(DayType.WEEKDAY, 80, DayType.WEEKEND, 110),
                    CustomerType.REWARD, Map.of(DayType.WEEKDAY, 50, DayType.WEEKEND, 90)
            ),
            4
    );

    Hotel miamiDowntown = new Hotel(
            "Miami Downtown",
            Map.of(
                    CustomerType.REGULAR, Map.of(DayType.WEEKDAY, 120, DayType.WEEKEND, 90),
                    CustomerType.REWARD, Map.of(DayType.WEEKDAY, 100, DayType.WEEKEND, 80)
            ),
            3
    );

    Hotel miamiMidtown = new Hotel(
            "Miami Midtown",
            Map.of(
                    CustomerType.REGULAR, Map.of(DayType.WEEKDAY, 100, DayType.WEEKEND, 150),
                    CustomerType.REWARD, Map.of(DayType.WEEKDAY, 70, DayType.WEEKEND, 130)
            ),
            5
    );
    List<Hotel> hotellist= List.of(miamiBeach,miamiDowntown,miamiMidtown);

    public List<Hotel> getHotels(){
        return hotellist;
    }

}
