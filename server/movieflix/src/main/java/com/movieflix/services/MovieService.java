package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;

public interface MovieService {

	Movie findById(Long id);

	Movie create(Movie movie);

	Movie update(Long id, Movie movie);

	void delete(Long id);

	public List<Movie> findBySearchData(String searchCatogoryType, String searchCatogoryValue, String sortType);

	List<Genre> getGenres();

}
