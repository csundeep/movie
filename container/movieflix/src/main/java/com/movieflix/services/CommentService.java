package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Comment;

public interface CommentService {

	public List<Comment> findAll(Long movieId);

	public Comment findById(Long id);

	public Comment update(Long id, Comment comment);

	public void delete(Long id);

	public Comment create(Comment comment, Long movieId, Long userId);

}
