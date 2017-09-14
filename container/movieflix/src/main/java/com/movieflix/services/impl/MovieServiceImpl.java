package com.movieflix.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.data.SearchType;
import com.movieflix.data.SortType;
import com.movieflix.entities.Genre;
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
		return (List<Movie>) repository.findAll();
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
		return repository.save(movie);
	}

	@Transactional
	public Movie update(Long id, Movie movie) {
		Movie movieInDB = repository.findById(id);
		if (movieInDB == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		return repository.save(movie);
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

		System.out.println(searchCatogoryType + "   " + searchCatogoryValue + " " + SearchType.movie_type + " "
				+ searchCatogoryType.equals(SearchType.movie_type.name()));

		if (searchCatogoryType.equals(SearchType.movie_type.name())) {
			if (sortType.equals(SortType.YEAR.name()))
				return repository.findByMovieTypeAndSortByYear(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_RATINGS.name()))
				return repository.findByMovieTypeAndSortByIMDBRating(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_VOTES.name()))
				return repository.findByMovieTypeAndSortByIMDBVotes(searchCatogoryValue);
			else
				return repository.findByMovieType(searchCatogoryValue);
		} else if (searchCatogoryType.equals(SearchType.year.name())) {
			if (sortType.equals(SortType.YEAR.name()))
				return repository.findByYearAndSortByYear(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_RATINGS.name()))
				return repository.findByYearAndSortByIMDBRating(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_VOTES.name()))
				return repository.findByYearAndSortByIMDBVotes(searchCatogoryValue);
			else
				return repository.findByYear(searchCatogoryValue);
		} else if (searchCatogoryType.equals(SearchType.genre.name())) {
			if (sortType.equals(SortType.YEAR.name()))
				return repository.findByGenreAndSortByYear(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_RATINGS.name()))
				return repository.findByGenreAndSortByIMDBRating(searchCatogoryValue);
			else if (sortType.equals(SortType.IMDB_VOTES.name()))
				return repository.findByGenreAndSortByIMDBVotes(searchCatogoryValue);
			else
				return repository.findByGenreType(searchCatogoryValue);
		} else {

			if (sortType.equals(SortType.YEAR.name()))
				return repository.findAllMoviesAndSortByYear();
			else if (sortType.equals(SortType.IMDB_RATINGS.name()))
				return repository.findAllMoviesAndSortByIMDBRating();
			else if (sortType.equals(SortType.IMDB_VOTES.name()))
				return repository.findAllMoviesAndSortByIMDBVotes();
			else
				return repository.findAll();
		}

	}

	@Override
	public List<Genre> getGenres() {
		return repository.getGenres();
	}

}
