package com.kenobi.ratingservice.services;

import com.kenobi.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating creteRating(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getAllRatingsByUser(String userId);
    List<Rating> getAllRatingsByHotel(String hotelId);

}
