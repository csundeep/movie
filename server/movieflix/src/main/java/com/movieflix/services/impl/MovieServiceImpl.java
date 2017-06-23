package com.movieflix.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.entities.Movie;
import com.movieflix.exceptions.MovieAlreadyExistsException;
import com.movieflix.exceptions.MovieNotFoundException;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	public List<Movie> findAll() {
		return repository.findAll();
	}

	public Movie findById(Long id) {
		Movie movie = repository.findById(id);
		if (movie == null) {
			throw new MovieNotFoundException("User with id:" + id + " not found");
		}
		return movie;
	}

	@Transactional
	public Movie create(Movie movie) {
		Movie movieInDB = repository.findByTitle(movie.getTitle());
		if (movieInDB != null) {
			throw new MovieAlreadyExistsException("Movie Already exists: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Transactional
	public Movie update(Long id, Movie movie) {
		Movie movieInDB = repository.findById(id);
		if (movieInDB == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		return repository.update(movie);
	}

	@Transactional
	public void delete(Long id) {
		Movie movieInDB = repository.findById(id);
		if (movieInDB == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		repository.delete(movieInDB);

	}

	public List<Movie> findBySearchData(String searchCatogoryType, String searchCatogoryValue, String sortType) {
		return repository.findBySearchData(searchCatogoryType, searchCatogoryValue, sortType);
	}

}
