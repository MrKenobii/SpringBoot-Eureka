package com.kenobi.hotelservice.services.impl;

import com.kenobi.hotelservice.entities.Hotel;
import com.kenobi.hotelservice.exceptions.ResourceNotFoundException;
import com.kenobi.hotelservice.repositories.HotelRepository;
import com.kenobi.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String s = UUID.randomUUID().toString();
        hotel.setId(s);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with id: " + id + " not found!"));
    }
}
