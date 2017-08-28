package com.movieflix.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.movieflix.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	public Comment findById(Long id);
	public List<Comment> findByMovieId(Long movieId);

}
