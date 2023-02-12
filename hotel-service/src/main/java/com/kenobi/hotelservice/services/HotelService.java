package com.kenobi.hotelservice.services;

import com.kenobi.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotel(String id);
}
