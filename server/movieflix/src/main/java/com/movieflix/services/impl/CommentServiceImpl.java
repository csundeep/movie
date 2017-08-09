package com.movieflix.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.entities.Comment;
import com.movieflix.entities.Movie;
import com.movieflix.entities.User;
import com.movieflix.exceptions.EntityNotFoundException;
import com.movieflix.repositories.CommentRepository;
import com.movieflix.services.CommentService;
import com.movieflix.services.MovieService;
import com.movieflix.services.UserService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository repository;
	@Autowired
	UserService userService;
	@Autowired
	MovieService movieService;

	public List<Comment> findAll(Long movieId) {
		return repository.findAll(movieId);
	}

	public Comment findById(Long id) {
		Comment existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return existing;
	}

	@Transactional
	public Comment create(Comment comment, Long movieId, Long userId) {
		Movie movie = movieService.findById(movieId);
		User user = userService.findById(userId);
		comment.setUser(user);
		comment.setMovie(movie);
		comment.setCreatedAt(new Date());
		return repository.create(comment);
	}

	@Transactional
	public Comment update(Long id, Comment comment) {
		Comment commentInDB = repository.findById(id);
		if (commentInDB == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return repository.update(comment);
	}

	@Transactional
	public void delete(Long id) {
		Comment commentInDB = repository.findById(id);
		if (commentInDB == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		repository.delete(commentInDB);
	}
}
