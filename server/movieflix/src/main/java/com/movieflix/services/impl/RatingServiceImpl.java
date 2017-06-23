package com.movieflix.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.entities.Movie;
import com.movieflix.entities.Rating;
import com.movieflix.entities.User;
import com.movieflix.exceptions.RatingAlreadyExistsException;
import com.movieflix.exceptions.RatingNotFoundException;
import com.movieflix.repositories.RatingRepository;
import com.movieflix.services.MovieService;
import com.movieflix.services.RatingService;
import com.movieflix.services.UserService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository repository;
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;

	public Rating findById(Long id) {
		Rating ratingInDB = repository.findById(id);
		if (ratingInDB == null) {
			throw new RatingNotFoundException("Rating with id:" + id + " not found");
		}
		return ratingInDB;
	}

	@Transactional
	public Rating create(Rating rating, Long movieId, Long userId) {
		List<Rating> ratingInDB = repository.findByUserIdMovieId(userId, movieId);
		if (ratingInDB.size() != 0) {
			throw new RatingAlreadyExistsException(
					"Rating already created with movie " + movieId + " and for the user " + userId);
		}
		Movie movie = movieService.findById(movieId);
		User user = userService.findById(userId);
		rating.setUser(user);
		rating.setMovie(movie);
		return repository.create(rating);
	}

	@Transactional
	public Rating update(Long id, Rating rating) {
		Rating ratingInDB = repository.findById(id);
		if (ratingInDB == null) {
			throw new RatingNotFoundException("Rating with id:" + id + " not found");
		}
		return repository.update(rating);
	}

	@Transactional
	public void delete(Long id) {
		Rating ratingInDB = repository.findById(id);
		if (ratingInDB == null) {
			throw new RatingNotFoundException("Rating with id:" + id + " not found");
		}
		repository.delete(ratingInDB);
	}

	public List<Rating> findAll() {
		return repository.findAll();
	}

	public double findAverageRatingForAMovie(Long movieId) {
		return repository.findAverageRatingForAMovie(movieId);
	}

}
