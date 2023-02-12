package com.kenobi.ratingservice.services.impl;

import com.kenobi.ratingservice.entities.Rating;
import com.kenobi.ratingservice.repositories.RatingRepository;
import com.kenobi.ratingservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    @Override
    public Rating creteRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUser(String userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotel(String hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}
