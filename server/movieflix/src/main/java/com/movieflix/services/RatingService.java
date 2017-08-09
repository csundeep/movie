package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Rating;

public interface RatingService {

	Rating findById(Long id);

	Rating create(Rating rating, Long movieId, Long userId);

	Rating update(Long id, Rating rating);

	void delete(Long id);

	List<Rating> findAll();

	double findAverageRatingForAMovie(Long movieId);

	Rating findByMovieIdAndUserId(Long movieId, Long userId);

}
