package com.movieflix.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieflix.data.SearchType;
import com.movieflix.data.SortType;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Movie> findAll() {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	public Movie findById(Long id) {
		return entityManager.find(Movie.class, id);
	}

	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("movieTitle", title);
		List<Movie> Movies = query.getResultList();
		if (Movies != null && Movies.size() == 1) {
			return Movies.get(0);
		}
		return null;
	}

	public Movie create(Movie movie) {
		entityManager.persist(movie);
		return movie;
	}

	public Movie update(Movie emp) {
		return entityManager.merge(emp);
	}

	public void delete(Movie emp) {
		entityManager.remove(emp);
	}

	public List<Movie> findBySearchData(String searchCatogoryType, String searchCatogoryValue, String sortType) {
		TypedQuery<Movie> query = null;

		if (searchCatogoryType.equals(SearchType.movie_type)) {
			if (sortType.equals(SortType.YEAR))
				query = entityManager.createNamedQuery("Movie.findByMovieTypeAndSortByYear", Movie.class);
			else if (sortType.equals(SortType.IMDB_RATINGS))
				query = entityManager.createNamedQuery("Movie.findByMovieTypeAndSortByIMDBRating", Movie.class);
			else if (sortType.equals(SortType.IMDB_VOTES))
				query = entityManager.createNamedQuery("Movie.findByMovieTypeAndSortByIMDBVotes", Movie.class);
			else
				query = entityManager.createNamedQuery("Movie.findByMovieType", Movie.class);
			query.setParameter("movieType", searchCatogoryValue);
		} else if (searchCatogoryType.equals(SearchType.year)) {
			if (sortType.equals(SortType.YEAR))
				query = entityManager.createNamedQuery("Movie.findByYearAndSortByYear", Movie.class);
			else if (sortType.equals(SortType.IMDB_RATINGS))
				query = entityManager.createNamedQuery("Movie.findByYearAndSortByIMDBRating", Movie.class);
			else if (sortType.equals(SortType.IMDB_VOTES))
				query = entityManager.createNamedQuery("Movie.findByYearAndSortByIMDBVotes", Movie.class);
			else
				query = entityManager.createNamedQuery("Movie.findByYear", Movie.class);
			query.setParameter("year", Integer.parseInt(searchCatogoryValue));
		} else if (searchCatogoryType.equals(SearchType.genre)) {
			if (sortType.equals(SortType.YEAR))
				query = entityManager.createNamedQuery("Movie.findByGenreAndSortByYear", Movie.class);
			else if (sortType.equals(SortType.IMDB_RATINGS))
				query = entityManager.createNamedQuery("Movie.findByGenreAndSortByIMDBRating", Movie.class);
			else if (sortType.equals(SortType.IMDB_VOTES))
				query = entityManager.createNamedQuery("Movie.findByGenreAndSortByIMDBVotes", Movie.class);
			else
				query = entityManager.createNamedQuery("Movie.findByGenre", Movie.class);
			query.setParameter("genre", searchCatogoryValue);
		} else {

			if (sortType.equals(SortType.YEAR))
				query = entityManager.createNamedQuery("Movie.findAllMoviesAndSortByYear", Movie.class);
			else if (sortType.equals(SortType.IMDB_RATINGS))
				query = entityManager.createNamedQuery("Movie.findAllMoviesAndSortByIMDBRating", Movie.class);
			else if (sortType.equals(SortType.IMDB_VOTES))
				query = entityManager.createNamedQuery("Movie.findAllMoviesAndSortByIMDBVotes", Movie.class);
			else
				query = entityManager.createNamedQuery("Movie.findAll", Movie.class);
		}

		List<Movie> movies = query.getResultList();
		return movies;
	}

}
