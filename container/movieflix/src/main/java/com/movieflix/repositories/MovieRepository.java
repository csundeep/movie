package com.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	Movie findById(Long id);

	Movie findByTitle(String title);

	@Query("SELECT m FROM Genre m ORDER BY m.genereType ASC")
	List<Genre> getGenres();

	// Search by movieType
	@Query("SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.year DESC")
	List<Movie> findByMovieTypeAndSortByYear(@Param(value = "movieType") String movieType);

	@Query("SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.imdbRating DESC")
	List<Movie> findByMovieTypeAndSortByIMDBRating(@Param(value = "movieType") String movieType);

	@Query("SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.imdbVotes DESC")
	List<Movie> findByMovieTypeAndSortByIMDBVotes(@Param(value = "movieType") String movieType);

	@Query("SELECT m FROM Movie m WHERE m.movieType=:movieType ORDER BY m.title ASC")
	List<Movie> findByMovieType(@Param(value = "movieType") String movieType);

	// Search by year
	@Query("SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.year DESC")
	List<Movie> findByYearAndSortByYear(@Param(value = "year") String year);

	@Query("SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.imdbRating DESC")
	List<Movie> findByYearAndSortByIMDBRating(@Param(value = "year") String year);

	@Query("SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.imdbVotes DESC")
	List<Movie> findByYearAndSortByIMDBVotes(@Param(value = "year") String year);

	@Query("SELECT m FROM Movie m WHERE m.year=:year ORDER BY m.title ASC")
	List<Movie> findByYear(@Param(value = "year") String year);

	// Search by genre
	@Query("select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.year DESC")
	List<Movie> findByGenreAndSortByYear(@Param(value = "genre") String genre);

	@Query("select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.imdbRating DESC")
	List<Movie> findByGenreAndSortByIMDBRating(@Param(value = "genre") String genre);

	@Query("select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.imdbVotes DESC")
	List<Movie> findByGenreAndSortByIMDBVotes(@Param(value = "genre") String genre);

	@Query("select m from Movie m inner join m.genre g where g.genereType = :genre ORDER BY m.title ASC")
	List<Movie> findByGenreType(@Param(value = "genre") String genre);

	// search all
	@Query("SELECT m FROM Movie m ORDER BY m.year DESC")
	List<Movie> findAllMoviesAndSortByYear();

	@Query("SELECT m FROM Movie m ORDER BY m.imdbVotes DESC")
	List<Movie> findAllMoviesAndSortByIMDBVotes();

	@Query("SELECT m FROM Movie m ORDER BY m.imdbRating DESC")
	List<Movie> findAllMoviesAndSortByIMDBRating();

	@Query("SELECT m FROM Movie m ORDER BY m.title ASC")
	List<Movie> findAll();

}
