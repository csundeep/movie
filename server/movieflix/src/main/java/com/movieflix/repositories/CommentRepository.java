package com.movieflix.repositories;

import java.util.List;

import com.movieflix.entities.Comment;

public interface CommentRepository {

	public List<Comment> findAll(Long movieId);

	public Comment findById(Long id);

	public Comment create(Comment comment);

	public Comment update(Comment comment);

	public void delete(Comment commentInDB);

}
