package com.movieflix.repositories;

import java.util.List;

import com.movieflix.entities.Movie;

public interface MovieRepository {

	List<Movie> findAll();

	Movie findById(Long id);

	Movie findByTitle(String title);

	Movie create(Movie movie);

	Movie update(Movie movie);

	void delete(Movie movieInDB);

	List<Movie> findBySearchData(String searchCatogoryType, String searchCatogoryValue, String sortType);

}
