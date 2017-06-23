package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.entities.Comment;
import com.movieflix.services.CommentService;

@RestController
@RequestMapping(path = "comments")
public class CommentController {

	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findAll(@RequestParam("movie_id") Long movieId) {
		return service.findAll(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Comment findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Comment create(@RequestBody Comment comment, @RequestParam("movie_id") Long movieId,
			@RequestParam("user_id") Long userId) {
		return service.create(comment, movieId, userId);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}")
	public Comment update(@PathVariable("id") Long id, @RequestBody Comment comment) {
		return service.update(id, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
