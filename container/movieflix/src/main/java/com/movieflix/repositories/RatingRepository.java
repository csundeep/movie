package com.movieflix.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.movieflix.entities.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

	Rating findById(Long id);

	Rating findByUserIdAndMovieId(Long userId, Long movieId);

	@Query("select avg(r.totalRating) from Rating r where r.movie.id = :movieId")
	double findAverageRatingForAMovie(@Param(value = "movieId") Long movieId);

}
