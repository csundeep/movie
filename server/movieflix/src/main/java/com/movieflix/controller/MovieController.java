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

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;
import com.movieflix.services.MovieService;

@CrossOrigin
@RestController
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Movie findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "genres")
	public List<Genre> getGenres() {
		return service.getGenres();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findBySearchData(@RequestParam(name = "searchCatogoryType") String searchCatogoryType,
			@RequestParam(name = "searchCatogoryValue") String searchCatogoryValue,
			@RequestParam(name = "sortType") String sortType) {
		return service.findBySearchData(searchCatogoryType, searchCatogoryValue, sortType);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}")
	public Movie update(@PathVariable("id") Long id, @RequestBody Movie movie) {
		return service.update(id, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
