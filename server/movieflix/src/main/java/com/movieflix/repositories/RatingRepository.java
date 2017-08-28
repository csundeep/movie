package com.movieflix.repositories;

import java.util.List;

import com.movieflix.entities.Rating;

public interface RatingRepository {

	Rating findById(Long id);

	Rating findByUserIdMovieId(Long userId, Long movieId);

	Rating create(Rating rating);

	Rating update(Rating emp);

	void delete(Rating ratingInDB);

	List<Rating> findAll();

	double findAverageRatingForAMovie(Long movieId);

}
