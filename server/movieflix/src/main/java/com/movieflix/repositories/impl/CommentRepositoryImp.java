package com.movieflix.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieflix.entities.Comment;
import com.movieflix.repositories.CommentRepository;

@Repository
public class CommentRepositoryImp implements CommentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Comment> findAll(Long movieId) {
		TypedQuery<Comment> query;
		if (movieId != null) {
			query = entityManager.createNamedQuery("Comment.findByMovieId", Comment.class);
			query.setParameter("movieId", movieId);
		} else
			query = entityManager.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findById(Long id) {
		return entityManager.find(Comment.class, id);
	}

	@Override
	public Comment create(Comment comment) {
		entityManager.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment emp) {
		return entityManager.merge(emp);
	}

	@Override
	public void delete(Comment emp) {
		entityManager.remove(emp);
	}
}