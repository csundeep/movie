package com.movieflix.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieflix.entities.Rating;
import com.movieflix.repositories.RatingRepository;

@Repository
public class RatingRepositoryImpl implements RatingRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Rating> findByUserIdMovieId(Long userId, Long movieId) {
		TypedQuery<Rating> query = entityManager.createNamedQuery("Rating.findByUserIdAndMovieId", Rating.class);
		query.setParameter("userId", userId);
		query.setParameter("movieId", movieId);
		return query.getResultList();
	}

	@Override
	public Rating findById(Long id) {
		return entityManager.find(Rating.class, id);
	}

	@Override
	public Rating create(Rating emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	public Rating update(Rating emp) {
		return entityManager.merge(emp);
	}

	@Override
	public void delete(Rating emp) {
		entityManager.remove(emp);
	}

	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = entityManager.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}

	@Override
	public double findAverageRatingForAMovie(Long movieId) {
		TypedQuery<Double> query;
		double avg = 0;
		if (movieId != null) {
			query = entityManager.createNamedQuery("Rating.findAvgByMovieId", Double.class);
			query.setParameter("movieId", movieId);
			avg = query.getSingleResult();
		}
		return avg;
	}
}
