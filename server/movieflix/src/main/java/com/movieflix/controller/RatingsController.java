package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.entities.Rating;
import com.movieflix.services.RatingService;

@CrossOrigin
@RestController
@RequestMapping(path = "ratings")
public class RatingsController {
	@Autowired
	private RatingService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "average")
	public double findAverageRatingForAMovie(@RequestParam("movie_id") Long movieId) {
		return service.findAverageRatingForAMovie(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{movie_id}/{user_id}")
	public Rating findByMovieIdAndUserId(@PathVariable("movie_id") Long movieId, @PathVariable("user_id") Long userId) {
		return service.findByMovieIdAndUserId(movieId, userId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Rating findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Rating create(@RequestBody Rating rating, @RequestParam("movie_id") Long movieId,
			@RequestParam("user_id") Long userId) {
		return service.create(rating, movieId, userId);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}")
	public Rating update(@PathVariable("id") Long id, @RequestBody Rating rating) {
		return service.update(id, rating);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}