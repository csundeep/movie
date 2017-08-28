package com.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	Movie findById(Long id);

	Movie findByTitle(String title);

	@Query("SELECT m FROM Movie m ORDER BY m.title ASC")
	List<Movie> findBySearchData(String searchCatogoryType, String searchCatogoryValue, String sortType);

	@Query("SELECT m FROM Genre m ORDER BY m.genereType ASC")
	List<Genre> getGenres();

}
